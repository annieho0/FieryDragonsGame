import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

// should always have 4 of these. these attach onto the indentedCard
// each will have a different animal on it
public class Cave extends JPanel {

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // Set color for the circle
    g.setColor(Color.RED);
    // Draw a circle that is centered within the panel
    int diameter = Math.min(getWidth(), getHeight());
    int x = (getWidth() - diameter) / 2;
    int y = (getHeight() - diameter) / 2;
    g.fillOval(x, y, diameter, diameter);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(50, 50); // Set the preferred size of the circle panel
  }

}
