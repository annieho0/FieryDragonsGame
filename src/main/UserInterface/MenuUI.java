package main.UserInterface;

import main.Buttons.MenuButton;
import main.Dragons.GreenDragon;
import main.Dragons.PinkDragon;
import main.Dragons.PurpDragon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MenuUI extends JPanel  {
    int screenWidth;
    int screenHeight;
    int dragonWidth = 200;
    int dragonHeight = 200;
    int buttonWidth = 200;
    int buttonHeight = 60;
    Image backgroundImage;
    String backgroundImageName = "src/images/Background.png";

    public MenuUI (int screenWidth, int screenHeight) {
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
            Font VT323Font = Font.createFont(Font.TRUETYPE_FONT, new File("VT323-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(VT323Font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        Font buttonFont = new Font("VT323", Font.BOLD, 40);


        MenuButton buttonStart = new MenuButton("BACK");
        buttonStart.setFont(buttonFont);
        buttonStart.setBounds((screenWidth-buttonWidth)/2, screenHeight/2 + 250, buttonWidth, buttonHeight);
        add(buttonStart);

        MenuButton buttonTwoPlayer = new MenuButton("2 PLAYERS");
        buttonTwoPlayer.setFont(buttonFont);
        buttonTwoPlayer.setBounds((screenWidth-buttonWidth)/2 - 250, (screenHeight-dragonHeight)/2 + 220, buttonWidth, buttonHeight);
        add(buttonTwoPlayer);

        MenuButton buttonThreePlayer = new MenuButton("3 PLAYERS");
        buttonThreePlayer.setFont(buttonFont);
        buttonThreePlayer.setBounds((screenWidth-buttonWidth)/2, (screenHeight-dragonHeight)/2 + 220, buttonWidth, buttonHeight);
        add(buttonThreePlayer);

        MenuButton buttonFourPlayer = new MenuButton("4 PLAYERS");
        buttonFourPlayer.setFont(buttonFont);
        buttonFourPlayer.setBounds((screenWidth-buttonWidth)/2 + 250, (screenHeight-dragonHeight)/2 + 220, buttonWidth, buttonHeight);
        add(buttonFourPlayer);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("VT323", Font.BOLD, 90));

        String menuTitle= "SELECTION MENU";
        String playersTitle = "HOW MANY PLAYERS?";


        Font fontPlayer = new Font("VT323", Font.BOLD, 50);

        g2.drawImage(backgroundImage, 0, 0, screenWidth, screenHeight, this);

        g2.setColor(Color.BLACK);
        g2.fillRect(screenWidth/2 - 400, screenHeight/2 - 200 ,800, 400);

        g2.setColor(Color.BLACK);
        g2.drawString(menuTitle, (screenWidth - g2.getFontMetrics().stringWidth(menuTitle))/2, screenHeight/6);
        g2.setColor(Color.WHITE);
        g2.drawString(menuTitle, (screenWidth - g2.getFontMetrics().stringWidth(menuTitle))/2 + 5, screenHeight/6 + 5);

        g2.setFont(fontPlayer);
        g2.setColor(Color.WHITE);
        g2.drawString(playersTitle, (screenWidth - g2.getFontMetrics().stringWidth(playersTitle))/2, screenHeight/2 - 140);

        GreenDragon greenDragon = new GreenDragon((screenWidth-dragonWidth)/2 - 250, (screenHeight-dragonHeight)/2, dragonWidth, dragonHeight);
        greenDragon.draw(g2);
        PurpDragon purpDragon = new PurpDragon((screenWidth-dragonWidth)/2, (screenHeight-dragonHeight)/2, dragonWidth,dragonHeight);
        purpDragon.draw(g2);
        PinkDragon pinkDragon = new PinkDragon((screenWidth-dragonWidth)/2 + 250, (screenHeight-dragonHeight)/2, dragonWidth,dragonHeight);
        pinkDragon.draw(g2);

    }
}
