/**
 * Abstract Dragon class represents each Players character on the GameBoard. There are two to four of these in each game.
 *
 * Created by:
 * @author Navya Balraj
 */
public abstract class Dragon {
  private Location location;
  private int xPos;
  private int yPos;
  private String name;
  private GameBoard gameBoard;
  private String imagePath;

  /***
   * Constructor for Dragon class.
   *
   * @param gameBoard the Gameboard the Dragon is on
   * @param initialX the x value of the Location of the Dragon
   * @param initialY the y value of the Location of the Dragon
   * @param name of the Dragon
   * @param imagePath link where the image of the Dragon is
   * @param xPos the x position of the Dragon on the GameBoard
   * @param yPos the y position of the Dragon on the GameBoard
   */
  public Dragon(GameBoard gameBoard, int initialX, int initialY, String name, String imagePath, int xPos, int yPos){
    this.gameBoard = gameBoard;
    this.location = new Location(initialX, initialY);
    this.name = name;
    this.imagePath = imagePath;
    this.xPos = xPos;
    this.yPos = yPos;
  }

  /***
   * Getter for Location variable.
   *
   * @return location of this Dragon
   */
  public Location getLocation() {
    return location;
  }

  /***
   * Setter for Location variable.
   *
   * @param location of this Dragon
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /***
   * Getter for imagePath variable.
   *
   * @return imagePath as a string
   */
  public String getImagePath() {
    return imagePath;
  }
  /***
   * Setter for xPos (x position) variable
   *
   * @param xPos (x position) of this Dragon on the GameBoard
   */
  public void setxPos(int xPos) {
    this.xPos = xPos;
  }
  /***
   * Setter for yPos (y position) variable
   *
   * @param yPos (y position) of this Dragon on the GameBoard
   */
  public void setyPos(int yPos) {
    this.yPos = yPos;
  }
}
