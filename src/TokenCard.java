import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.util.Random;

/***
 * TokenCard class used to represent the 16 cards in the centre of the valcano GameBoard.
 *
 * Created by:
 * @author Navya Balraj
 */

class TokenCard extends JPanel {
  private final int tileSize;
  private GameLogic gameLogic;

  ArrayList<Integer> randomInts;

  /***
   * Constructor for TokenCard class.
   *
   * @param tileSize the units used in the GameBoard to indicate one location
   * @param gameLogic an instance of the class holding all the functionality for the logic of the game
   */
  public TokenCard(int tileSize, GameLogic gameLogic) {
    this.tileSize = tileSize;
    this.gameLogic = gameLogic;
    randomInts = createRandomArray();
  }

  /***
   * Method which put 2 random integers in the ArrayList per token which will be used as the x and y coordinates of the Tokens.
   *
   * @return an ArrayList of randomly selected Integers which will be used as locations for the tokens
   */
  public ArrayList<Integer> createRandomArray(){
    Random random = new Random();
    ArrayList<Integer> randomInts = new ArrayList<>();
    for (int i = 0; i < gameLogic.getTokensLength()*2; i++){
      randomInts.add(random.nextInt(5) + 2);
    }
    return randomInts;
  }

  /***
   * Method which paints the circular tokens in the centre of the GameBoard at random preselected locations.
   *
   * @param g represents the graphics context onto which the component should paint its content
   */
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
