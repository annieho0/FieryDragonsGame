import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
  private Image backgroundImage;

  public ImagePanel(String imagePath) {
    try {
      backgroundImage = ImageIO.read(new File(imagePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (backgroundImage != null) {
      // Draw the background image at the top-left corner of the panel
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
  }
}
