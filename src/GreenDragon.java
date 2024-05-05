/***
 * GreenDragon is a Dragon which the Players can use as their token.
 *
 * Created by:
 * @author Navya Balraj
 */
public class GreenDragon extends Dragon {
  /***
   * Constructor for GreenDragon class.
   *
   * @param gameBoard the Gameboard the GreenDragon is on
   * @param col the x value of the Location of the Dragon
   * @param row the y value of the Location of the Dragon
   */
  public GreenDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Green Dragon", "src/images/greendragon.jpeg", col*gameBoard.tileSize, row*gameBoard.tileSize);
  }
}
