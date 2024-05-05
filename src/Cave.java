import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class Cave extends JPanel {
  private final int tileSize;
  private Location location;
  private final Color caveColor; // Color of the cave
  private final int xPos; // X-coordinate of the cave's position
  private final int yPos; // Y-coordinate of the cave's position

  public Cave(int tileSize, Color caveColor, int xPos, int yPos, int initialX, int initialY) {
    this.tileSize = tileSize;
    this.caveColor = caveColor;
    this.xPos = xPos;
    this.yPos = yPos;
    this.setPreferredSize(new Dimension(tileSize, tileSize));
    this.location = new Location(initialX, initialY);
  }

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