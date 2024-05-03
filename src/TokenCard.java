import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

// represents 16 cards in the center of the volcano
// all should be implemented as circles facing downwards
// use random int generator to choose a token card

class TokenCard extends JPanel {
  private final int tileSize;
  private GameLogic gameLogic;
  private String[] tokens = new String[16];
  private String selectedToken;

  public TokenCard(int tileSize, GameLogic gameLogic) {
    this.tileSize = tileSize;
    this.gameLogic = gameLogic;
    this.selectedToken = "";
    addMouseListener(new TokenClickListener());
    tokens[0] = "1 Salamander";
    tokens[1] = "2 Salamanders";
    tokens[2] = "3 Salamanders";
    tokens[3] = "1 Bat";
    tokens[4] = "2 Bats";
    tokens[5] = "3 Bats";
    tokens[6] = "1 Spider";
    tokens[7] = "2 Spiders";
    tokens[8] = "3 Spiders";
    tokens[9] = "1 Baby Dragon";
    tokens[10] = "2 Baby Dragons";
    tokens[11] = "3 Baby Dragons";
    tokens[12] = "1 Pirate Dragon";
    tokens[13] = "1 Pirate Dragon";
    tokens[14] = "2 Pirate Dragons";
    tokens[15] = "2 Pirate Dragons";

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.ORANGE);
    Random random = new Random();
    for (int i = 0; i < 18; i++) {
      int circleDiameter = Math.min(tileSize / 2, tileSize / 2);
      int circleX = random.nextInt(5) + 2;
      int circleY = random.nextInt(5) + 2;
      circleX *= tileSize;
      circleY *= tileSize;
      g2d.fillOval(circleX, circleY, circleDiameter, circleDiameter);
    }
  }

  private class TokenClickListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      Random random = new Random();
      int randomIndex = random.nextInt(tokens.length); // Generate a random index within the array length
      selectedToken = tokens[randomIndex];
      gameLogic.run(TokenCard.this);
    }
  }
}