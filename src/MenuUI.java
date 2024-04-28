import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuUI extends JPanel implements ActionListener  {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 15;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 760
    final int screenHeight = tileSize * maxScreenRow; // 576
    Image img;
    Image blueDragon1;
    Image blueDragon2;
    Image greenDragon1;
    Image greenDragon2;
    Image purpDragon1;
    Image purpDragon2;
    int blueDragonX = ((screenWidth/5)*2)+22;
    int blueDragonY = screenHeight - 300;
    int greenDragonX = (screenWidth/5)+22;
    int greenDragonY = screenHeight - 300;
    int purpDragonX = ((screenWidth/5)*3)+22;
    int purpDragonY = screenHeight - 300;
    boolean useBlueDragon1 = true;
    boolean useGreenDragon1 = true;
    boolean usePurpDragon1 = true;

    public MenuUI() {
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

        MyButton button1 = new MyButton("BACK");
        button1.setFont(buttonFont);
        button1.setBounds(screenWidth/2 - 100, 500, 200, 60);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        add(button1);

        MyButton button2 = new MyButton("START");
        button2.setFont(buttonFont);
        button2.setBounds(screenWidth/2 - 100, 400, 200, 60);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setBorderPainted(false);
        button2.setForeground(Color.WHITE);
        button2.setFocusPainted(false);
        add(button2);
    }

    public void PictureAnimationMenu() {
        try {
            blueDragon1 = ImageIO.read(new File("BlueDragon1.png"));
            blueDragon2 = ImageIO.read(new File("BlueDragon2.png"));
            greenDragon1 = ImageIO.read(new File("GreenDragon1.png"));
            greenDragon2 = ImageIO.read(new File("GreenDragon2.png"));
            purpDragon1 = ImageIO.read(new File("PurpDragon1.png"));
            purpDragon2 = ImageIO.read(new File("PurpDragon2.png"));
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
        String text1 = "SELECTION MENU";

        Font font2 = new Font("VT323", Font.BOLD, 50);
        Font font3 = new Font("VT323", Font.BOLD, 24);
        int x = tileSize + 50;
        int y = tileSize + 60;

        g2.drawImage(img, 0, 0, screenWidth, screenHeight, this);
        g2.setColor(Color.BLACK);
        g2.drawString(text1, x + 4, y + 4);
        g2.setColor(Color.WHITE);
        g2.drawString(text1, x, y);

        g2.setFont(font2);
        g2.setColor(Color.BLACK);
        g2.fillRect(screenWidth/6,y + 22,(screenWidth/6)*4,350);
        g2.setColor(Color.WHITE);
        g2.drawString("HOW MANY PLAYERS", x + 100, screenHeight - 375);

        g2.setFont(font3);
        g2.setColor(Color.WHITE);
        g2.drawString("2 PLAYERS", (screenWidth/5)+22, screenHeight - 325);
        g2.drawString("3 PLAYERS", ((screenWidth/5)*2)+22, screenHeight - 325);
        g2.drawString("4 PLAYERS", ((screenWidth/5)*3)+22, screenHeight - 325);

        if (useBlueDragon1) {
            g2.drawImage(blueDragon1, blueDragonX, blueDragonY, 100,100, this);
        } else {
            g2.drawImage(blueDragon2, blueDragonX, blueDragonY, 100,100, this);
        }
        if (useGreenDragon1) {
            g2.drawImage(greenDragon1, greenDragonX, greenDragonY, 100,100,  this);
        } else {
            g2.drawImage(greenDragon2, greenDragonX, greenDragonY, 100,100,  this);
        }
        if (usePurpDragon1) {
            g2.drawImage(purpDragon1, purpDragonX, purpDragonY, 100,100,  this);
        } else {
            g2.drawImage(purpDragon2, purpDragonX,purpDragonY, 100,100, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        useBlueDragon1 = !useBlueDragon1;
        usePurpDragon1 = !usePurpDragon1;
        useGreenDragon1 = !useGreenDragon1;
        repaint();
    }

}

