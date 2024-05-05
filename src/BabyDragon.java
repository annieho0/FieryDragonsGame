/***
 * BabyDragon is an Animal on the cards of the game.
 *
 * Created by:
 * @author Navya Balraj
 */
public class BabyDragon extends Animal{

  /***
   * Constructor for BabyDragon class.
   *
   * @param gameBoard the Gameboard the BabyDragon is on
   * @param col the x value of the Location of the Animal
   * @param row the y value of the Location of the Animal
   */
  public BabyDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Baby Dragon", "src/images/babydragon.jpeg");
  }
}
