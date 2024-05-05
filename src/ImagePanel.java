import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/***
 * ImagePanel class used to display an image as the background of the panel.
 *
 * Created by:
 * @author Navya Balraj
 */
class ImagePanel extends JPanel {
  private Image backgroundImage;

  /***
   * Constructor for ImagePanel class.
   *
   * @param imagePath link where the image is
   */
  public ImagePanel(String imagePath) {
    try {
      backgroundImage = ImageIO.read(new File(imagePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /***
   * Method which paints the image on the background of the frame.
   *
   * @param g represents the graphics context onto which the component should paint its content
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (backgroundImage != null) {
      // Draw the background image at the top-left corner of the panel
      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
  }
}
