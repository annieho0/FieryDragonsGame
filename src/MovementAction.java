/***
 * MovementAction is a subclass of Action which implements the action of moving dragons.
 *
 * Created by:
 * @author Navya Balraj
 */
public class MovementAction extends Action {
  private Location oldLocation;
  private Location newLocation;
  private Dragon dragon;
  public Dragon capture;
  private int tileSize;

  /***
   * Constructor for MovementAction class.
   *
   * @param gameBoard the Gameboard where the movement is taking place
   * @param dragon which will be moved
   * @param newLocation where the Dragon will be moved to
   * @param tileSize the units used in the GameBoard to indicate one location
   */
  public MovementAction(GameBoard gameBoard, Dragon dragon, Location newLocation, int tileSize) {
    this.oldLocation = dragon.getLocation(); // Get the old location from the dragon
    this.newLocation = newLocation;
    this.dragon = dragon;
    this.capture = gameBoard.getDragon(newLocation); // Assuming getDragon method takes Location as argument
    this.tileSize = tileSize;
  }

  /***
   * Method which executes the effects of the Movement Action including changing the actual Location of the Dragon.
   *
   * @returns null for current implementation of Actions
   */
  @Override
  public String execute() {
    // Update the dragon's location
    dragon.setLocation(newLocation);

    // Update the dragon's position based on the new location
    dragon.setxPos(newLocation.getX() * tileSize);
    dragon.setyPos(newLocation.getY() * tileSize);

    return null;
  }
}
