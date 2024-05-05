import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/***
 * Cave class represents the four caves on the GameBoard where the Dragons will start and end their game play.
 *
 * Created by:
 * @author Navya Balraj
 */
class Cave extends JPanel {
  private final int tileSize;
  private Location location;
  private final Color caveColor; // Color of the cave
  private final int xPos; // X-coordinate of the cave's position
  private final int yPos; // Y-coordinate of the cave's position

  /***
   * Constructor for Cave class.
   *
   * @param tileSize the size of the tiles used on the GameBoard
   * @param caveColor the colour which this Cave will be
   * @param xPos the x value of the position of the Cave on the Gameboard
   * @param yPos the y value of the position of the Cave on the Gameboard
   * @param initialX the x value of the Location of the Cave on the Gameboard
   * @param initialY the y value of the Location of the Cave on the Gameboard
   */
  public Cave(int tileSize, Color caveColor, int xPos, int yPos, int initialX, int initialY) {
    this.tileSize = tileSize;
    this.caveColor = caveColor;
    this.xPos = xPos;
    this.yPos = yPos;
    this.setPreferredSize(new Dimension(tileSize, tileSize));
    this.location = new Location(initialX, initialY);
  }


  /***
   * Method which paints the circles onto the GameBoard given the size, colour and position.
   *
   * @param g represents the graphics context onto which the component should paint its content
   */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(caveColor);
    // Draw the circle
    g2d.fillOval(xPos, yPos, tileSize, tileSize);
    this.setOpaque(true);
    this.setVisible(true);
  }
}