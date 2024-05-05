/***
 * PinkDragon is a Dragon which the Players can use as their token.
 *
 * Created by:
 * @author Navya Balraj
 */
public class PinkDragon extends Dragon {

  /***
   * Constructor for PinkDragon class.
   *
   * @param gameBoard the Gameboard the PinkDragon is on
   * @param col the x value of the Location of the Dragon
   * @param row the y value of the Location of the Dragon
   */
  public PinkDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row,"Pink Dragon", "src/images/pinkdragon.jpeg",col*gameBoard.tileSize, row*gameBoard.tileSize);
  }

}
