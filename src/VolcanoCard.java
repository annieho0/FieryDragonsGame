import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

// implement a character on each of these ()
// should always have 24 of these
public class VolcanoCard extends JPanel {
  private BufferedImage image;

  public VolcanoCard(String imagePath) {
    loadImage(imagePath);
    setPreferredSize(new Dimension(100, 100)); // Adjust size as needed
  }

  // Method to load image
  private void loadImage(String imagePath) {
    try {
      image = ImageIO.read(new File(imagePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Draw the image on the top half of the tile
    if (image != null) {
      int imageHeight = image.getHeight();
      int halfHeight = getHeight() / 2;
      int y = (halfHeight - imageHeight) / 2; // Center the image vertically
      g.drawImage(image, 0, y, getWidth(), imageHeight, this);
    }
  }

}
