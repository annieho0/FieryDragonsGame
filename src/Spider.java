/***
 * Spider is an Animal on the cards of the game.
 *
 * Created by:
 * @author Navya Balraj
 */
public class Spider extends Animal {
  /***
   * Constructor for Spider class.
   *
   * @param gameBoard the Gameboard the Spider is on
   * @param col the x value of the Location of the Animal
   * @param row the y value of the Location of the Animal
   */
  public Spider(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Spider", "src/images/spider.jpeg");
  }
}
