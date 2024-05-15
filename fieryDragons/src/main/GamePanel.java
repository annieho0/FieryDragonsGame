package main;

import boardCards.AssetSetter;
import boardCards.ImageLoader;
import dragonCards.Cards;
import dragonCards.CircleManager;
import player.*;
import tile.TileManager;
import tokens.DragonCards;
import util.FindCoordinatesWithValue;
import winning.WinningPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class GamePanel extends JPanel implements Runnable, MouseListener {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;

    //FPS
    int fps = 60;
    GreenDragon greenDragon = new GreenDragon(this,12,12, PlayerTurn.GREEN);
    BlueDragon blueDragon = new BlueDragon(this, 12, 2, PlayerTurn.BLUE);
//    BlueDragon blueDragon = new BlueDragon(this, 11, 10, PlayerTurn.BLUE);
    PinkDragon pinkDragon = new PinkDragon(this, 4, 12, PlayerTurn.PINK);
    PurpleDragon purpleDragon = new PurpleDragon(this, 4, 2, PlayerTurn.PURPLE);
    TileManager tileManager = new TileManager(this);
    Thread gameThread;
    AssetSetter assetSetter = new AssetSetter(this);
    public DragonCards[] obj = new DragonCards[24];
    public Cards[] cards;
    public ArrayList<String> availableImages = new ArrayList<>();
    private List<int[]> coordinatesWithOne;
    FindCoordinatesWithValue coordinatesFinder;
    private CircleManager circleManager;
    private boolean skullCardFlipped = false;


    public GamePanel(){
        int screenWidth = tileSize * maxScreenCol;
        int screenHeight = tileSize * maxScreenRow;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(this);
        availableImages.addAll(ImageLoader.loadImages());

        coordinatesFinder = new FindCoordinatesWithValue();
        coordinatesWithOne = coordinatesFinder.getCoordinatesWithOne();
        sortCoordinatesClockwise();
        circleManager = new CircleManager(availableImages);
        circleManager.initializeCircles(screenWidth, screenHeight);
        cards = circleManager.getCards();

        for (int i = 0; i < coordinatesWithOne.size(); i++) {
            if (coordinatesWithOne.get(i)[0] == 11 && coordinatesWithOne.get(i)[1] == 6) {
                pinkDragonIndex = i;
                System.out.println(pinkDragonIndex);

            }else if (coordinatesWithOne.get(i)[0] == 5 && coordinatesWithOne.get(i)[1] == 4) {
                purpleDragonIndex = i;
                System.out.println(purpleDragonIndex);

            }else if (coordinatesWithOne.get(i)[0] == 3 && coordinatesWithOne.get(i)[1] == 10) { //else if (coordinatesWithOne.get(i)[0] == 5 && coordinatesWithOne.get(i)[1] == 12)
                blueDragonIndex = i;
                System.out.println(blueDragonIndex);

            }else if (coordinatesWithOne.get(i)[0] == 9 && coordinatesWithOne.get(i)[1] == 12) {
                greenDragonIndex = i;
                System.out.println(greenDragonIndex);

            }
        }
        switchPlayerTurn();

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
        assetSetter.setObject();
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update() {
//        switch (playerTurn) {
//            case PINK:
//                if (!skullCardFlipped) {
//                    pinkDragon.update();
//                }
//                break;
//            case PURPLE:
//                if (!skullCardFlipped) {
//                    purpleDragon.update();
//                }
//                break;
//            case BLUE:
//                if (!skullCardFlipped) {
//                    blueDragon.update();
//                }
//                break;
//            case GREEN:
//                if (!skullCardFlipped) {
//                    greenDragon.update();
//                }
//                break;
//        }
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
        if (cards != null) {
            for (Cards card : cards) {
                card.draw(g2);
            }
        }
        greenDragon.draw(g2);
        blueDragon.draw(g2);
        pinkDragon.draw(g2);
        purpleDragon.draw(g2);

        g2.dispose();

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

    private int pinkDragonIndex = -1;
    private int purpleDragonIndex = -1;
    private int blueDragonIndex = -1;
    private int greenDragonIndex = -1;
    private int dragonPositionIndex = -1;
    private int tilesMoved = 0;
    private boolean pinkDragonOnBoard = false;
    private boolean purpleDragonOnBoard = false;
    private boolean blueDragonOnBoard = false;
    private boolean greenDragonOnBoard = false;
    @Override
    public void mouseClicked(MouseEvent e) {
        if(tilesMoved < 25) {
            for (Cards card : this.cards) {
                if (card.contains(e.getX(), e.getY())) {
                    // Check if the card is flipped
                    boolean isFlipped = card.isFlipped();

                    // Flip the card (toggle the flipped state)
                    card.flip();

                    // Only move the dragon if the card is being flipped to its flipped state
                    if (!isFlipped) {

                        int[] nextPosition = coordinatesWithOne.get((dragonPositionIndex + 1) % coordinatesWithOne.size());
                        //                        int[] nextPosition = coordinatesWithOne.get(dragonPositionIndex);
                        System.out.println(Arrays.toString(nextPosition));
                        String cardImage = card.getBackImage().trim().toLowerCase();
                        String dragonImage = getDragonCardImage(nextPosition);
                        boolean dragonOnBoard = false;
                        switch (playerTurn) {
                            case PINK:
                                dragonOnBoard = pinkDragonOnBoard;
                                break;
                            case PURPLE:
                                dragonOnBoard = purpleDragonOnBoard;
                                break;
                            case BLUE:
                                dragonOnBoard = blueDragonOnBoard;
                                break;
                            case GREEN:
                                dragonOnBoard = greenDragonOnBoard;
                                break;
                        }System.out.println(dragonOnBoard);
                        if (cardImage.contains("skull")) {
                            if (dragonOnBoard) {

                                int movement = 1;
                                if (cardImage.contains("2")) {
                                    movement = 2;
                                }
                                // Move the dragon back by the specified number of tiles
                                dragonPositionIndex = (dragonPositionIndex - movement + coordinatesWithOne.size()) % coordinatesWithOne.size();
                                nextPosition = coordinatesWithOne.get(dragonPositionIndex);
                                moveDragonToPosition(nextPosition, dragonPositionIndex);
//                                pinkDragon.setCurrentPosition(nextPosition[1], nextPosition[0]); // Coordinates are flipped in the list
                                tilesMoved -= movement;
                                // Update the panel to reflect changes
                                switchPlayerTurn();
                                repaint();
                                break;
                            }else{
                            switchPlayerTurn();
                            return;
                        }
                        }
//
                        if (isMatch(cardImage, dragonImage)) {
                            if (cardImage.contains("2")) {
                                moveDragonForward(2, cardImage);
                            } else if (cardImage.contains("3")) {
                                moveDragonForward(3, cardImage);

                            } else {
                                moveDragonForward(1, cardImage);
                            }
                        } else{
                            switchPlayerTurn();
                            repaint();
                        }

                    }
                }

            }
        }
        if (tilesMoved == 25) {
            // Trigger the win condition
            System.out.println("Congratulations! You have won the game!");
            WinningPage winningPage = new WinningPage();
        }

    }
    private boolean isMatch(String cardImage, String dragonImage) {
        // Check if the card image matches the dragon card/tile image
        return cardImage.contains(getBaseName(dragonImage));
    }
    private String getBaseName(String imagePath) {
        // Extract the base name from the image path
        String[] parts = imagePath.split("/");
        return parts[parts.length - 1].split("\\.")[0];
    }

    private String getDragonCardImage(int[] nextPosition) {
        DragonCards dragon = assetSetter.getObjectAtCoordinate(Arrays.toString(nextPosition));
        if (dragon != null) {
            // Get the dragon card/tile image
            return dragon.getImagePath().trim().toLowerCase();
        }
        return "";
    }

    private void moveDragonForward(int steps, String cardImage) {
        int originalIndex = dragonPositionIndex; // Store the original index
        for (int i = 0; i < steps; i++) {
            dragonPositionIndex = (dragonPositionIndex + 1) % coordinatesWithOne.size();
            int[] nextPosition = coordinatesWithOne.get(dragonPositionIndex);
            String dragonImage = getDragonCardImage(nextPosition);
            System.out.println(Arrays.toString(nextPosition));
            System.out.println(cardImage + dragonImage);
            if (!isMatch(cardImage, dragonImage)) {
                // If any of the images doesn't match, revert the index and exit
                dragonPositionIndex = originalIndex;
                switchPlayerTurn();
                return;
            }
        }

        int[] finalPosition = coordinatesWithOne.get(dragonPositionIndex);
        moveDragonToPosition(finalPosition, dragonPositionIndex);

// Update the corresponding dragonOnBoard flag
        switch (playerTurn) {
            case PINK:
                pinkDragonOnBoard = true;
                break;
            case PURPLE:
                purpleDragonOnBoard = true;
                break;
            case BLUE:
                blueDragonOnBoard = true;
                break;
            case GREEN:
                greenDragonOnBoard = true;
                break;
            default:
                // Handle the default case
        }

        tilesMoved += steps;
        repaint();

    }

    // Create a map to store the positions of all dragons
    private Map<String, int[]> dragonPositions = new HashMap<>();

private void moveDragonToPosition(int[] position, int dragonPositionIndex) {
    // Check if the position is already occupied
    if (dragonPositions.containsValue(position)) {
        System.out.println("Position occupied");
        switchPlayerTurn();
        return;
    }

    switch (playerTurn) {
        case PINK:
            pinkDragon.setCurrentPosition(position[1], position[0]);
            pinkDragonIndex = dragonPositionIndex;
            // Update the position in the map
            dragonPositions.put("PINK", position);
            break;
        case PURPLE:
            purpleDragon.setCurrentPosition(position[1], position[0]);
            purpleDragonIndex = dragonPositionIndex;
            // Update the position in the map
            dragonPositions.put("PURPLE", position);
            break;
        case BLUE:
            blueDragon.setCurrentPosition(position[1], position[0]);
            blueDragonIndex = dragonPositionIndex;
            // Update the position in the map
            dragonPositions.put("BLUE", position);
            break;
        case GREEN:
            greenDragon.setCurrentPosition(position[1], position[0]);
            greenDragonIndex = dragonPositionIndex;
            // Update the position in the map
            dragonPositions.put("GREEN", position);
            break;
        default:
            return; // Handle the default case
    }

    repaint(); // Update panel
}


    private PlayerTurn playerTurn = PlayerTurn.GREEN;
    private void switchPlayerTurn(){

        playerTurn = playerTurn.next();

        switch (playerTurn) {
            case PINK:
                dragonPositionIndex = pinkDragonIndex;

                break;
            case PURPLE:
                dragonPositionIndex = purpleDragonIndex;

                break;
            case BLUE:
                dragonPositionIndex = blueDragonIndex;

                break;
            case GREEN:
                dragonPositionIndex = greenDragonIndex;

                break;
        }
        System.out.println("Player turn: " + playerTurn);
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
