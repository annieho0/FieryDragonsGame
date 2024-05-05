public abstract class Animal {
  private Location location;
  private GameBoard gameBoard;
  public String imagePath;
  public String name;
  public Animal(GameBoard gameBoard, int initialX, int initialY, String name, String imagePath){
    this.gameBoard = gameBoard;
    this.location = new Location(initialX, initialY);
    this.name = name;
    this.imagePath = imagePath;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getImagePath() {
    return imagePath;
  }
}
