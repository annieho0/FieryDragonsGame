import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 15;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 758 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    Image img;

    public GamePanel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

//        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60));
//        Font arialFont = new Font("Arial", Font.BOLD, 96F);
//        g2.setFont(arialFont);
        g2.setFont(new Font("VT323",Font.BOLD, 90));
        String text = "FIERY DRAGONS";
        int x = tileSize + 60;
        int y = tileSize + 60;

        g2.drawImage(img, 0, 0, screenWidth, screenHeight, this);
        g2.setColor(Color.BLACK);
        g2.drawString(text, x+4, y+4);
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

    }

}