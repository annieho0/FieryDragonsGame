package main;

import boardCards.AssetSetter;
import circle.Circle;
import tile.TileManager;
import tokens.DragonCards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable, MouseListener {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;

    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int fps = 60;

    TileManager tileManager = new TileManager(this);
    Thread gameThread;
    AssetSetter assetSetter = new AssetSetter(this);
    public DragonCards[] obj = new DragonCards[24];
    Circle[] circles;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(this);
    }
    public void setupGame(){
        assetSetter.setObject();
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void update() {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100, tileSize, tileSize);
        tileManager.draw(g2);
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }
        if (circles == null) {
            initializeCircles();
        }

        // Draw circles
        for (Circle circle : circles) {
            circle.draw(g2);
        }
        g2.dispose();

    }
    private void initializeCircles() {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Calculate circle radius
        int radius = Math.min(getWidth(), getHeight()) / 5; // Adjust the divisor for desired spacing

        // Initialize circles
        int numCircles = 16;
        int circleSize = 35;
        double angleStep = 2 * Math.PI / numCircles;
        circles = new Circle[numCircles];
        for (int i = 0; i < numCircles; i++) {
            double angle = angleStep * i;
            int xOffset = 25; // Adjust this value to move the circles further to the right
            int circleX = (int) (centerX + radius * Math.cos(angle)) - (circleSize / 2) + xOffset;
            int yOffset = 25;
            int circleY = (int) (centerY + radius * Math.sin(angle)) - (circleSize / 2) - yOffset;
            circles[i] = new Circle(circleX, circleY, circleSize);}
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
        // Handle mouse click event
        for (Circle circle : circles) {
            if (circle.contains(e.getX(), e.getY())) {
                circle.setClicked(true);
                // Generate a random number to choose between skull, bat, and spider
                Random random = new Random();
                int randomNumber = random.nextInt(5); // Generate a random number between 0 and 2

                String imagePath;
                // Choose the image file path based on the random number
                switch (randomNumber) {
                    case 0:
                        imagePath = "Project/res/objects/skull.png";
                        break;
                    case 1:
                        imagePath = "Project/res/objects/bat.gif";
                        break;
                    case 2:
                        imagePath = "Project/res/objects/spider.png";
                        break;
                    case 3:
                        imagePath = "Project/res/objects/egg.png";
                        break;
                    case 4:
                        imagePath = "Project/res/objects/lizard.png";
                        break;
                    default:
                        // Default to skull.png if random number is out of bounds
                        imagePath = "Project/res/objects/skull.png";
                }

                circle.setImage(imagePath); // Set the randomly chosen image for the clicked circle
                repaint(); // Update the panel to reflect changes
                break; // Break loop after clicking the first circle that was clicked
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