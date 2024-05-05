import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.util.Random;

// represents 16 cards in the center of the volcano
// all should be implemented as circles facing downwards
// use random int generator to choose a token card

class TokenCard extends JPanel {
  private final int tileSize;
  private GameLogic gameLogic;

  ArrayList<Integer> randomInts;

  public TokenCard(int tileSize, GameLogic gameLogic) {
    this.tileSize = tileSize;
    this.gameLogic = gameLogic;
    randomInts = createRandomArray();
  }

  public ArrayList<Integer> createRandomArray(){
    Random random = new Random();
    ArrayList<Integer> randomInts = new ArrayList<>();
    for (int i = 0; i < gameLogic.getTokensLength()*2; i++){
      randomInts.add(random.nextInt(5) + 2);
    }
    return randomInts;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.ORANGE);

    for (int i = 0; i < randomInts.size(); i=i+2){
      int circleDiameter = Math.min(tileSize / 2, tileSize / 2);
      int circleX = randomInts.get(i);
      int circleY = randomInts.get(i+1);
      circleX *= tileSize;
      circleY *= tileSize;
      g2d.fillOval(circleX, circleY, circleDiameter, circleDiameter);
    }

    }
  }
