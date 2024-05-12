package main;

import boardCards.AssetSetter;
import dragonCards.Cards;
import player.*;
import tile.TileManager;
import tokens.DragonCards;
import util.FindCoordinatesWithValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePanel extends JPanel implements Runnable, MouseListener {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;

    //FPS
    int fps = 60;
    GreenDragon greenDragon = new GreenDragon(this,12,12);
    BlueDragon blueDragon = new BlueDragon(this, 12, 2);
    PinkDragon pinkDragon = new PinkDragon(this, 4, 12);
    private boolean isFirstClick = true;
    PurpleDragon purpleDragon = new PurpleDragon(this, 4, 2);
    TileManager tileManager = new TileManager(this);
    Thread gameThread;
    AssetSetter assetSetter = new AssetSetter(this);
    public DragonCards[] obj = new DragonCards[24];
    public Cards[] cards;
    public ArrayList<String> availableImages = new ArrayList<>();
    private List<int[]> coordinatesWithOne;

    public GamePanel(){
        int screenWidth = tileSize * maxScreenCol;
        int screenHeight = tileSize * maxScreenRow;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(this);
        availableImages.add("/objects/bat.gif");
        availableImages.add("/objects/bat_2.png");
        availableImages.add("/objects/bat_3.png");
        availableImages.add("/objects/spider.png");
        availableImages.add("/objects/spider_2.png");
        availableImages.add("/objects/spider_3.png");
        availableImages.add("/objects/egg.png");
        availableImages.add("/objects/egg_2.png");
        availableImages.add("/objects/egg_3.png");
        availableImages.add("/objects/lizard.png");
        availableImages.add("/objects/lizard_2.png");
        availableImages.add("/objects/lizard_3.png");
        availableImages.add("/objects/skull.png");
        availableImages.add("/objects/skull_2.png");
        availableImages.add("/objects/skull.png");
        availableImages.add("/objects/skull_2.png");

        FindCoordinatesWithValue coordinatesFinder = new FindCoordinatesWithValue();
        coordinatesWithOne = coordinatesFinder.getCoordinatesWithOne();
        sortCoordinatesClockwise();

        for (int i = 0; i < coordinatesWithOne.size(); i++) {
            if (coordinatesWithOne.get(i)[0] == 11 && coordinatesWithOne.get(i)[1] == 6) {
                dragonPositionIndex = i;
                break;
            }
        }

    }
    private void sortCoordinatesClockwise() {
        // Calculate the center point of the grid
        int centerX = maxScreenCol / 2;
        int centerY = maxScreenRow / 2;

        // Sort coordinates based on their angle from the center in the opposite order
        Collections.sort(coordinatesWithOne, (a, b) -> {
            double angleA = Math.atan2(a[1] - centerY, a[0] - centerX);
            double angleB = Math.atan2(b[1] - centerY, b[0] - centerX);
            // Reverse the comparison to sort in counterclockwise order
            return Double.compare(angleB, angleA);
        });
    }
    public void setupGame(){
        AssetSetter.setObject();
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update() {
        greenDragon.update();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        tileManager.draw(g2);
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        if (cards == null) {
            initializeCircles();
        }

        // Draw cards
        for (Cards cards : this.cards) {
            cards.draw(g2);
        }
        greenDragon.draw(g2);
        blueDragon.draw(g2);
        pinkDragon.draw(g2);
        purpleDragon.draw(g2);

        g2.dispose();

    }


    public void initializeCircles() {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Calculate circle radius
            int radius = Math.min(getWidth(), getHeight()) / 5;

            // Initialize cards
            int numCircles = 16;
            int circleSize = 40;
            double angleStep = 2 * Math.PI / numCircles;
            cards = new Cards[numCircles];

            // Shuffle the list of available images
            Collections.shuffle(availableImages);

            for (int i = 0; i < numCircles; i++) {
                double angle = angleStep * i;
                int xOffset = 25;
                int circleX = (int) (centerX + radius * Math.cos(angle)) - (circleSize / 2) + xOffset;
                int yOffset = 25;
                int circleY = (int) (centerY + radius * Math.sin(angle)) - (circleSize / 2) - yOffset;
                cards[i] = new Cards(circleX, circleY, circleSize);
                // Set front image for each circle
                cards[i].setFrontImage("/objects/dragon.png");
                // Set back image for each circle from shuffled list
                String backImagePath = availableImages.get(i);
                cards[i].setBackImage(backImagePath, i);
            }
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/fps;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while( gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / (drawInterval);
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;

            }

            if(timer >= 1000000000){
                drawCount =0;
                timer =0;
            }

        }

    }
    private boolean isMatch(String cardImage, String dragonImage) {
        // Check if the card image matches the dragon card/tile image
        return cardImage.contains(dragonImage);
    }

    private String getDragonCardImage(int[] nextPosition) {
        int index = coordinatesWithOne.indexOf(nextPosition);
        if (index >= 0 && index < obj.length) {
            DragonCards dragon = obj[index];
            if (dragon != null) {
                // Get the dragon card/tile image
                return dragon.getImagePath().trim().toLowerCase();
            }
        }
        return "";
    }

    private int dragonPositionIndex = -1;

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Cards card : this.cards) {
            if (card.contains(e.getX(), e.getY())) {
                // Check if the card is flipped
                boolean isFlipped = card.isFlipped();

                // Flip the card (toggle the flipped state)
                card.flip();

                // Only move the dragon if the card is being flipped to its flipped state
                if (!isFlipped) {
                    // Check if the flipped card's image matches one of the predefined asset names
                    String[] assetNames = {"spider", "spider_2", "spider_3", "bat", "bat_2", "bat_3", "egg", "egg_2", "egg_3", "lizard", "lizard_2", "lizard_3"};
                    boolean contain = false;
                    for (String name : assetNames) {
                        System.out.println(name);
                        if (card.getBackImage().toLowerCase().contains(name)) {
                            contain = true;
                            break;
                        }
                    }

                    if (contain) {
                        int[] nextPosition = coordinatesWithOne.get(dragonPositionIndex);
                        System.out.println(dragonPositionIndex);

                        // Get the just flipped card's image
                        String cardImage = card.getBackImage().trim().toLowerCase();

                        // Get the dragon card/tile image at the next position
                        String dragonImage = getDragonCardImage(nextPosition);

                        // Check if the just flipped card matches the dragon card/tile image at the next position
                        if (isMatch(cardImage, dragonImage)) {
                            dragonPositionIndex = (dragonPositionIndex + 1) % coordinatesWithOne.size();
                            nextPosition = coordinatesWithOne.get(dragonPositionIndex);
                            // Do something when the dragon card matches the flipped card
                            System.out.println("match");
                            // Set the current position of the pink dragon
                            pinkDragon.setCurrentPosition(nextPosition[1], nextPosition[0]); // Coordinates are flipped in the list
                        }

                        // Update the panel to reflect changes
                        repaint();

                        break;
                    } else {
                        // If the flipped card's image is not in assetNames, move the dragon back
                        // Check if the image name contains "1" or "2" and move accordingly
                        int movement = 1;
                        if (card.getBackImage().contains("1")) {
                            movement = 1;
                        } else if (card.getBackImage().contains("2")) {
                            movement = 2;
                        }
                        // Move the dragon back by the specified number of tiles
                        dragonPositionIndex = (dragonPositionIndex - movement + coordinatesWithOne.size()) % coordinatesWithOne.size();
                        int[] nextPosition = coordinatesWithOne.get(dragonPositionIndex);
                        pinkDragon.setCurrentPosition(nextPosition[1], nextPosition[0]); // Coordinates are flipped in the list
                        // Update the panel to reflect changes
                        repaint();
                    }
                }
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}