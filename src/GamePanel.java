import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements ActionListener {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 15;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 758 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    Image img;
    Image blueDragon1;
    Image blueDragon2;
    boolean useBlueDragon1 = true;

    public GamePanel() {
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

        // Create the button
        MyButton button1 = new MyButton("LOAD GAME");
        // Set button bound
        button1.setFont(buttonFont);
        button1.setBounds(screenWidth / 2 - 100, 135, 200, 60); // Example bounds, adjust as needed
        // Add button to panel
        add(button1);

        //Create the button
        MyButton button2 = new MyButton("EXIT");
        // Set button bounds
        button2.setFont(buttonFont);
        button2.setBounds(screenWidth / 2 - 100, 210, 200, 60); // Example bounds, adjust as needed
        // Add button to panel
        add(button2);
    }

    public void PictureAnimation() {
        // Load the image
        try {
            blueDragon1 = ImageIO.read(new File("BlueDragon1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            blueDragon2 = ImageIO.read(new File("BlueDragon2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start a timer to update the animation
        Timer timer = new Timer(800, this); // 50 milliseconds interval
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
            if (useBlueDragon1) {
                g2.drawImage(blueDragon1, 20, 50, 70, 70, this);
            } else {
                g2.drawImage(blueDragon2, 20, 50, 70, 70, this);
            }}

    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch between the two dragon images
        useBlueDragon1 = !useBlueDragon1;

        // Repaint the panel to show the updated dragon image
        repaint();
    }
}



