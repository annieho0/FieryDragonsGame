/***
 * Bat is an Animal on the cards of the game.
 *
 * Created by:
 * @author Navya Balraj
 */
public class Bat extends Animal{
  /***
   * Constructor for Bat class.
   *
   *
   * @param gameBoard the Gameboard the Bat is on
   * @param col the x value of the Location of the Animal
   * @param row the y value of the Location of the Animal
   */
  public Bat(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col , row, "Bat", "src/images/bat.jpeg");
  }
}
