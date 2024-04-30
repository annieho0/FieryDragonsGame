package main;

import boardCards.AssetSetter;
import circle.Circle;
import tile.TileManager;
import tokens.DragonCards;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable, MouseListener {
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;

    //FPS
    int fps = 60;

    TileManager tileManager = new TileManager(this);
    Thread gameThread;
    AssetSetter assetSetter = new AssetSetter(this);
    public DragonCards[] obj = new DragonCards[24];
    public Circle[] circles;
    public ArrayList<String> availableImages = new ArrayList<>();


    public GamePanel(){
        int screenWidth = tileSize * maxScreenCol;
        int screenHeight = tileSize * maxScreenRow;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(this);
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\bat.gif");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\bat_2.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\bat_3.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\spider.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\spider_2.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\spider_3.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\egg.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\egg_2.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\egg_3.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\lizard.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\lizard_2.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\lizard_3.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\skull.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\skull_2.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\skull.png");
        availableImages.add("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\skull_2.png");

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


    public void initializeCircles() {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Calculate circle radius
            int radius = Math.min(getWidth(), getHeight()) / 5;

            // Initialize circles
            int numCircles = 16;
            int circleSize = 40;
            double angleStep = 2 * Math.PI / numCircles;
            circles = new Circle[numCircles];

            // Shuffle the list of available images
            Collections.shuffle(availableImages);

            for (int i = 0; i < numCircles; i++) {
                double angle = angleStep * i;
                int xOffset = 25;
                int circleX = (int) (centerX + radius * Math.cos(angle)) - (circleSize / 2) + xOffset;
                int yOffset = 25;
                int circleY = (int) (centerY + radius * Math.sin(angle)) - (circleSize / 2) - yOffset;
                circles[i] = new Circle(circleX, circleY, circleSize);
                // Set front image for each circle
                circles[i].setFrontImage("C:\\Users\\annie\\IdeaProjects\\CL_Monday06pm\\fieryDragons\\res\\objects\\dragon.png");
                // Set back image for each circle from shuffled list
                String backImagePath = availableImages.get(i);
                circles[i].setBackImage(backImagePath, i);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        for (Circle circle : circles) {
            if (circle.contains(e.getX(), e.getY())) {
                circle.flip(); // Toggle the flipped state
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