public abstract class Dragon {
  private Location location;
  private int xPos;
  private int yPos;
  private String name;
  private GameBoard gameBoard;
  private String imagePath;

  public Dragon(GameBoard gameBoard, int initialX, int initialY, String name, String imagePath, int xPos, int yPos){
    this.gameBoard = gameBoard;
    this.location = new Location(initialX, initialY);
    this.name = name;
    this.imagePath = imagePath;
    this.xPos = xPos;
    this.yPos = yPos;
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

  public void setxPos(int xPos) {
    this.xPos = xPos;
  }

  public void setyPos(int yPos) {
    this.yPos = yPos;
  }
}
