package main;

import boardCards.AssetSetter;
import boardCards.ImageLoader;
import dragonCards.Cards;
import dragonCards.CircleManager;
import player.*;
import tile.TileManager;
import tokens.DragonCards;
import util.FindCoordinatesWithValue;
import util.FontLoader;
import winning.WinningPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

/**
 * Represents the panel where the game is displayed.
 */
public class GamePanel extends JPanel implements Runnable, MouseListener {

    // Constants for tile size and other properties

    /**
     * The original size of a tile before scaling.
     */
    final int originalTileSize = 16;

    /**
     * The scale factor for resizing tiles.
     */
    final int scale = 3;

    /**
     * The size of a tile after scaling.
     */
    public final int tileSize = originalTileSize * scale;

    /**
     * The maximum number of columns to be displayed on the screen.
     */
    public final int maxScreenCol = 16;

    /**
     * The maximum number of rows to be displayed on the screen.
     */
    public final int maxScreenRow = 16;

    //FPS
    int fps = 60;
    GreenDragon greenDragon = new GreenDragon(this,12,12, PlayerTurn.GREEN);
    BlueDragon blueDragon = new BlueDragon(this, 12, 2, PlayerTurn.BLUE);
    PinkDragon pinkDragon = new PinkDragon(this, 4, 12, PlayerTurn.PINK);
    PurpleDragon purpleDragon = new PurpleDragon(this, 4, 2, PlayerTurn.PURPLE);
    TileManager tileManager = new TileManager(this);
    Thread gameThread;
    AssetSetter assetSetter = new AssetSetter(this);
    public DragonCards[] obj = new DragonCards[28];
    public Cards[] cards;
    private Font pixelFont;
    public ArrayList<String> availableImages = new ArrayList<>();
    private List<int[]> coordinatesWithOne;
    FindCoordinatesWithValue coordinatesFinder;
    private CircleManager circleManager;
    private int pinkDragonIndex = -1;
    private int purpleDragonIndex = -1;
    private int blueDragonIndex = -1;
    private int greenDragonIndex = -1;
    private int dragonPositionIndex = -1;
    private int tilesMoved = 0;
    private int pinkTilesMoved = 0;
    private int purpleTilesMoved = 0;
    private int blueTilesMoved = 0;
    private int greenTilesMoved = 0;
    private boolean pinkDragonOnBoard = false;
    private boolean purpleDragonOnBoard = false;
    private boolean blueDragonOnBoard = false;
    private boolean greenDragonOnBoard = false;
    private static final int MESSAGE_DISPLAY_TIME = 3000; // Time in milliseconds to display each message
    private String message = ""; // Current message to display
    private long messageDisplayStartTime = 0;


    /**
     * Constructs a new GamePanel object.
     */
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


            }else if (coordinatesWithOne.get(i)[0] == 5 && coordinatesWithOne.get(i)[1] == 4) {
                purpleDragonIndex = i;


            }else if (coordinatesWithOne.get(i)[0] == 3 && coordinatesWithOne.get(i)[1] == 10) { //else if (coordinatesWithOne.get(i)[0] == 5 && coordinatesWithOne.get(i)[1] == 12)
                blueDragonIndex = i;


            }else if (coordinatesWithOne.get(i)[0] == 9 && coordinatesWithOne.get(i)[1] == 12) {
                greenDragonIndex = i;


            }
        }
        switchPlayerTurn();
        FontLoader fontLoader = new FontLoader();
        pixelFont = fontLoader.getPixelFont();

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

    /**
     * Sets up the game assets.
     */
    public void setupGame(){
        assetSetter.setObject();
    }

    /**
     * Starts the game thread.
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Sets a message to be displayed on the game panel.
     *
     * @param message The message to be displayed.
     */
    public void setMessage(String message) {
        this.message = message;
        this.messageDisplayStartTime = System.currentTimeMillis();
        repaint(); // Trigger repaint to display the message
    }

    /**
     * Updates the game state.
     */
    public void update() {

    }

    /**
     * Paints the game components on the panel.
     *
     * @param g The Graphics object to paint on.
     */
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

        if (!message.isEmpty() && (System.currentTimeMillis() - messageDisplayStartTime) < MESSAGE_DISPLAY_TIME) {
            drawMessage(g2, message);
        }

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
                        System.out.println(pinkDragon.getX());
                        String cardImage = card.getBackImage().trim().toLowerCase();
                        String dragonImage = getDragonCardImage(nextPosition);
                        boolean dragonOnBoard = false;
                        switch (playerTurn) {
                            case PINK:
                                dragonOnBoard = pinkDragonOnBoard;
//                                tilesMoved = pinkTilesMoved;

                                break;
                            case PURPLE:
                                dragonOnBoard = purpleDragonOnBoard;
//                                tilesMoved = purpleTilesMoved;
                                break;
                            case BLUE:
                                dragonOnBoard = blueDragonOnBoard;
//                                tilesMoved = blueTilesMoved;
                                break;
                            case GREEN:
                                dragonOnBoard = greenDragonOnBoard;
//                                tilesMoved = greenTilesMoved;
                                break;
                        }
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
                                switch (playerTurn) {
                                    case PINK:
                                        pinkTilesMoved -= movement;
                                        break;
                                    case PURPLE:
                                        purpleTilesMoved -= movement;
                                        break;
                                    case BLUE:
                                        blueTilesMoved -= movement;
                                        break;
                                    case GREEN:
                                        greenTilesMoved -= movement;
                                        break;
                                }
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
        }System.out.println(pinkTilesMoved + "purple: " + purpleTilesMoved +"blue: " + blueTilesMoved +"green: "+ greenTilesMoved);
        if (((pinkTilesMoved == 25) || (purpleTilesMoved == 25) || (blueTilesMoved == 25) || (greenTilesMoved == 25))) {
            // Trigger the win condition
            setMessage("Congratulations! You have won the game!");

            WinningPage winningPage = new WinningPage(playerTurn.toString().toLowerCase());
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
//        int originalIndex = dragonPositionIndex; // Store the original index
        for (int i = 0; i < steps; i++) {
            dragonPositionIndex = (dragonPositionIndex + 1) % coordinatesWithOne.size();
            int[] nextPosition = coordinatesWithOne.get(dragonPositionIndex);
            String dragonImage = getDragonCardImage(nextPosition);

//            if (!isMatch(cardImage, dragonImage)) {
//                // If any of the images doesn't match, revert the index and exit
//                dragonPositionIndex = originalIndex;
//                switchPlayerTurn();
//                return;
//            }
        }

        int[] finalPosition = coordinatesWithOne.get(dragonPositionIndex);
        moveDragonToPosition(finalPosition, dragonPositionIndex);

// Update the corresponding dragonOnBoard flag
        switch (playerTurn) {
            case PINK:
                pinkDragonOnBoard = true;
                pinkTilesMoved += steps;
                break;
            case PURPLE:
                purpleDragonOnBoard = true;
                purpleTilesMoved += steps;
                break;
            case BLUE:
                blueDragonOnBoard = true;
                blueTilesMoved += steps;
                break;
            case GREEN:
                greenDragonOnBoard = true;
                greenTilesMoved += steps;
                break;
            default:
                // Handle the default case
        }

        repaint();

    }

    // Create a map to store the positions of all dragons
    private Map<String, int[]> dragonPositions = new HashMap<>();

private void moveDragonToPosition(int[] position, int dragonPositionIndex) {
    // Check if the position is already occupied
    if (dragonPositions.containsValue(position)) {
        setMessage("Position occupied");
        switchPlayerTurn();
        switch (playerTurn) {
            case PINK:
                pinkTilesMoved --;
                break;
            case PURPLE:
                purpleTilesMoved --;
                break;
            case BLUE:
                blueTilesMoved --;
                break;
            case GREEN:
                greenTilesMoved --;
                break;
        }
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
        setMessage("Player turn: " + playerTurn);
    }

    /**
     * Draws a message on the game panel.
     *
     * @param g2 The Graphics2D object to draw with.
     * @param message The message to be drawn.
     */
    private void drawMessage(Graphics2D g2, String message) {
        // Set up font and color for the message
        g2.setColor(Color.WHITE);
        g2.setFont(pixelFont); // Use the loaded font

        // Draw the message (centered)
        FontMetrics fm = g2.getFontMetrics();
        int messageWidth = fm.stringWidth(message);
        int x = (getWidth() - messageWidth) / 2;
        int y = getHeight() / 2;
        g2.drawString(message, x, y);
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
