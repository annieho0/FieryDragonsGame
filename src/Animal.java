public abstract class Animal {
  private Location location;
  public String imagePath;
  public String name;
  private GameBoard gameBoard;
  /***
   * Constructor.
   *
   * @param name the name of this Item
   * @param displayChar the character to use to represent this item if it is on the ground
   * @param portable true if and only if the Item can be picked up
   */
  public Animal(GameBoard gameBoard, int initialX, int initialY, String name, String imagePath){
    this.gameBoard = gameBoard;
    this.location = new Location(initialX, initialY);
    this.name = name;
    this.imagePath = imagePath;
  }

  public Location getLocation() {
    return location;
  }
}
