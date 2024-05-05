/***
 * BlueDragon is a Dragon which the Players can use as their token.
 *
 * Created by:
 * @author Navya Balraj
 */
public class BlueDragon extends Dragon {

  /***
   * Constructor for BlueDragon class.
   *
   * @param gameBoard the Gameboard the BueDragon is on
   * @param col the x value of the Location of the Dragon
   * @param row the y value of the Location of the Dragon
   */
  public BlueDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Blue Dragon", "src/images/bluedragon.jpeg", col*gameBoard.tileSize, row*gameBoard.tileSize);
  }
}
