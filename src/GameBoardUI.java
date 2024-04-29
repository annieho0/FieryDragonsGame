import Dragons.BlueDragon;
import Dragons.GreyDragon;
import Dragons.PinkDragon;
import Dragons.PurpDragon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameBoardUI extends JPanel {
    final int screenWidth = 800;
    final int screenHeight = 800;
    final int outerRadius = screenWidth/2-100;
    final int innerRadius = screenWidth/2-200;
    final int caveHeight = 150;
    final int caveWidth = 150;
    Image background;
    String backgroundImg = "BoardBackground1.png";
    String fontName = "VT323-Regular.ttf";

    public GameBoardUI() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        setLayout(null);

        try {
            background = ImageIO.read(new File(backgroundImg));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Font VT323Font = Font.createFont(Font.TRUETYPE_FONT, new File(fontName));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(VT323Font);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        Font buttonFont = new Font("VT323", Font.BOLD, 40);

        int buttonHeight = 70;
        int buttonWidth = 70;
        int scale = outerRadius + 25;

        // Temporary buttons to represent chit cards
        BoardButton buttonOneStep = new BoardButton("1");
        buttonOneStep.setFont(buttonFont);
        buttonOneStep.setBounds((scale-buttonWidth), (scale-buttonWidth), buttonWidth, buttonHeight);
        add(buttonOneStep);

        BoardButton buttonTwoStep = new BoardButton("2");
        buttonTwoStep.setFont(buttonFont);
        buttonTwoStep.setBounds((screenWidth-scale), (scale-buttonWidth), buttonWidth, buttonHeight);
        add(buttonTwoStep);

        BoardButton buttonThreeStep = new BoardButton("3");
        buttonThreeStep.setFont(buttonFont);
        buttonThreeStep.setBounds((scale-buttonWidth), (screenHeight-scale), buttonWidth, buttonHeight);
        add(buttonThreeStep);

        BoardButton buttonFourStep = new BoardButton("4");
        buttonFourStep.setFont(buttonFont);
        buttonFourStep.setBounds((screenWidth-scale), (screenHeight-scale), buttonWidth, buttonHeight);
        add(buttonFourStep);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // drawing of the circular board without sections
        g2.setColor(Color.WHITE);
        g2.drawOval((screenWidth-outerRadius*2)/2, (screenHeight-outerRadius*2)/2, 2*outerRadius, 2*outerRadius);
        g2.setColor(Color.WHITE);
        g2.drawOval((screenWidth-innerRadius*2)/2, (screenHeight-innerRadius*2)/2, 2*innerRadius, 2*innerRadius);
        g2.drawImage(background, (screenWidth/2)-150, (screenHeight/2)-150, screenWidth-500, screenHeight-500, this);


        g2.setColor(Color.WHITE);
        Cave leftUpCave = new Cave(50,50,caveWidth, caveHeight);
        Cave rightUpCave = new Cave(600,50, caveWidth, caveHeight);
        Cave leftLowCave = new Cave(50,600, caveWidth, caveHeight);
        Cave rightLowCave = new Cave(600,600, caveWidth, caveHeight);

        leftUpCave.draw(g2);
        rightUpCave.draw(g2);
        leftLowCave.draw(g2);
        rightLowCave.draw(g2);

        GreyDragon greyDragon = new GreyDragon(50,50,100,100);
        greyDragon.draw(g2);
        BlueDragon blueDragon = new BlueDragon(600, 600, 100, 100);
        blueDragon.draw(g2);
        PinkDragon pinkDragon = new PinkDragon(60, 600, 100,100);
        pinkDragon.draw(g2);
        PurpDragon purpDragon = new PurpDragon(600, 50, 100,100);
        purpDragon.draw(g2);
    }


}
