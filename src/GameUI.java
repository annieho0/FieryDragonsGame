import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameUI extends JPanel implements ActionListener {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 15;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 720
    final int screenHeight = tileSize * maxScreenRow; // 576
    Image img;
    Image greyDragon1;
    Image greyDragon2;
    boolean useGreyDragon1 = true;
    int dragonX = (screenWidth/2) - 100;
    int dragonY = screenHeight - 275;

    public GameUI() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        setLayout(null);

        try {
            img = ImageIO.read(new File("Background.jpg"));
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

        MyButton button1 = new MyButton("LOAD GAME");
        button1.setFont(buttonFont);
        button1.setBounds(screenWidth / 2 - 100, 135, 200, 60);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        add(button1);

        MyButton button2 = new MyButton("EXIT");
        button2.setFont(buttonFont);
        button2.setBounds(screenWidth / 2 - 100, 210, 200, 60);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        add(button2);
    }

    public void PictureAnimationTitle() {
        try {
            greyDragon1 = ImageIO.read(new File("GreyDragon1.png"));
            greyDragon2 = ImageIO.read(new File("GreyDragon2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer(600, this);
        timer.start();
    }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            g2.setFont(new Font("VT323", Font.BOLD, 90));
            String text = "FIERY DRAGONS";
            int x = tileSize + 60;
            int y = tileSize + 60;

            g2.drawImage(img, 0, 0, screenWidth, screenHeight, this);
            g2.setColor(Color.BLACK);
            g2.drawString(text, x + 4, y + 4);
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);
            if (useGreyDragon1) {
                g2.drawImage(greyDragon1, dragonX, dragonY, 200, 200, this);
            } else {
                g2.drawImage(greyDragon2, dragonX, dragonY, 200, 200, this);
            }}

    @Override
    public void actionPerformed(ActionEvent e) {
        useGreyDragon1 = !useGreyDragon1;
        repaint();
    }
}



