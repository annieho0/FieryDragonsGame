/***
 * PurpleDragon is a Dragon which the Players can use as their token.
 *
 * Created by:
 * @author Navya Balraj
 */
public class PurpleDragon extends Dragon {

  /***
   * Constructor for PurpleDragon class.
   *
   * @param gameBoard the Gameboard the PurpleDragon is on
   * @param col the x value of the Location of the Dragon
   * @param row the y value of the Location of the Dragon
   */
  public PurpleDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Purple Dragon", "src/images/purpledragon.jpeg", col*gameBoard.tileSize, row*gameBoard.tileSize);
  }

}
