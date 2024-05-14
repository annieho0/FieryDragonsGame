package main;

import util.MainButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainPanel extends JPanel {
    int screenWidth;
    int screenHeight;
    Image backgroundImage;
    String backgroundImageName = "fieryDragons/res/objects/Background.png";
    Image greyDragonImage;
    String greyDragonImageName = "fieryDragons/res/objects/GreyDragon.png";

    public MainPanel(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.setDoubleBuffered(true);
        setLayout(null);

        try {
            backgroundImage = ImageIO.read(new File(backgroundImageName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            greyDragonImage = ImageIO.read(new File(greyDragonImageName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Font VT323Font = Font.createFont(Font.TRUETYPE_FONT, new File("fieryDragons/res/VT323-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(VT323Font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        Font buttonFont = new Font("VT323", Font.BOLD, 40);

        MainButton buttonLoad = new MainButton("LOAD GAME");
        buttonLoad.setFont(buttonFont);
        buttonLoad.setBounds(screenWidth / 2 - 100, screenHeight / 4 + 70, 200, 60);
        add(buttonLoad);

        MainButton buttonExit = new MainButton("EXIT");
        buttonExit.setFont(buttonFont);
        buttonExit.setBounds(screenWidth / 2 - 100, screenHeight / 4 + 160, 200, 60);
        add(buttonExit);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("VT323", Font.BOLD, 120));
        String gameTitle = "FIERY DRAGONS";

        g2.drawImage(backgroundImage, 0, 0, screenWidth, screenHeight, this);

        g2.setColor(Color.BLACK);
        g2.drawString(gameTitle, (screenWidth - g2.getFontMetrics().stringWidth(gameTitle)) / 2, screenHeight / 4);
        g2.setColor(Color.WHITE);
        g2.drawString(gameTitle, (screenWidth - g2.getFontMetrics().stringWidth(gameTitle)) / 2 + 5, screenHeight / 4 + 5);

        g2.drawImage(greyDragonImage, screenWidth / 2 - 100, screenHeight / 2 + 80, 200, 200, this);
    }
}


