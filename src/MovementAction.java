public class MovementAction extends Action {
  private Location oldLocation;
  private Location newLocation;
  private Dragon dragon;
  public Dragon capture;
  private int tileSize;

  public MovementAction(GameBoard gameBoard, Dragon dragon, Location newLocation, int tileSize) {
    this.oldLocation = dragon.getLocation(); // Get the old location from the dragon
    this.newLocation = newLocation;
    this.dragon = dragon;
    this.capture = gameBoard.getDragon(newLocation); // Assuming getDragon method takes Location as argument
    this.tileSize = tileSize;
  }

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
