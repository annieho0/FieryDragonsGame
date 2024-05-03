import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

// should always have 4 of these. these attach onto the indentedCard
// each will have a different animal on it
class Cave extends JPanel {
  private final int tileSize;
  private int noOfCaves;

  public Cave(int tileSize, int noOfCaves) {
    this.tileSize = tileSize;
    this.noOfCaves = noOfCaves;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;


    g2d.setColor(new Color(147, 123, 199));
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        int circleDiameter = Math.min(tileSize, tileSize);
        int circleX = c * tileSize;
        int circleY = r * tileSize;
        if (r == 1 && c == 4) {
          g2d.fillOval(circleX, circleY - circleDiameter / 2, circleDiameter, circleDiameter);
          BufferedImage purpleDragonImage = loadImage("src/images/purpledragon.jpeg");
          drawImage(g2d, circleX, circleY - circleDiameter / 2, purpleDragonImage,tileSize/2,tileSize/2);
          // drawText(g2d,r*tileSize,c*tileSize,"1");
        } else if (r == 7 && c == 4) {
          g2d.setColor(new Color(184, 105, 203));
          g2d.fillOval(circleX, circleY + circleDiameter / 2, circleDiameter, circleDiameter);
          if (noOfCaves >= 2) {
            BufferedImage pinkDragonImage = loadImage("src/images/pinkdragon.jpeg");
            drawImage(g2d, circleX, circleY + circleDiameter / 2, pinkDragonImage, tileSize / 2,
                tileSize / 2);
          }
          // drawText(g2d,r*tileSize,c*tileSize,"2");
        } else if (c == 1 && r == 4) {
          g2d.setColor(new Color(97, 150, 206));
          g2d.fillOval(circleX - circleDiameter / 2, circleY, circleDiameter, circleDiameter);
          if (noOfCaves >= 3) {
            BufferedImage blueDragonImage = loadImage("src/images/bluedragon.jpeg");
            drawImage(g2d, circleX - circleDiameter / 2, circleY, blueDragonImage, tileSize / 2,
                tileSize / 2);
          }
          // drawText(g2d,r*tileSize,c*tileSize,"3");
        } else if (c == 7 && r == 4) {
          g2d.setColor(new Color(129, 206, 134));
          g2d.fillOval(circleX + circleDiameter / 2, circleY, circleDiameter, circleDiameter);
          if (noOfCaves >= 4) {
            BufferedImage greenDragonImage = loadImage("src/images/greendragon.jpeg");
            drawImage(g2d, circleX + circleDiameter / 2, circleY, greenDragonImage, tileSize / 2,
                tileSize / 2);
          }
          // drawText(g2d,r*tileSize,c*tileSize,"4");
        }
      }
    }

  }

  private void drawText(Graphics2D g2d, int x, int y, String text) {
    FontMetrics fm = g2d.getFontMetrics();
    int textWidth = fm.stringWidth(text);
    int textHeight = fm.getHeight();
    int textX = x + (tileSize - textWidth) / 2;
    int textY = y + (tileSize + textHeight) / 2;
    g2d.setColor(Color.BLACK);
    g2d.drawString(text, textX, textY);
  }


  private void drawImage(Graphics2D g2d, int x, int y, BufferedImage image, int width, int height) {
    // Calculate the position to center the resized image within the circle
    int imageX = x + (tileSize - width) / 2;
    int imageY = y + (tileSize - height) / 2;

    // Draw the resized image
    g2d.drawImage(image, imageX, imageY, width, height, null);
  }

  private BufferedImage loadImage(String imagePath) {
    try {
      return ImageIO.read(new File(imagePath));
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}