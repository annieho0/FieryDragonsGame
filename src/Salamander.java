/***
 * Salamander is an Animal on the cards of the game.
 *
 * Created by:
 * @author Navya Balraj
 */
public class Salamander extends Animal{
  /***
   * Constructor for Salamander class.
   *
   * @param gameBoard the Gameboard the Salamander is on
   * @param col the x value of the Location of the Animal
   * @param row the y value of the Location of the Animal
   */
  public Salamander(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Salamander", "src/images/salamander.jpeg");
  }
}
