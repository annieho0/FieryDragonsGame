/***
 * Location class represents the x and y value of the location of each element in the GameBoard.
 *
 * Created by:
 * @author Navya Balraj
 */
public class Location {
  private int x;
  private int y;

  /***
   * Constructor for Location class.
   *
   * @param x the x coordination of the location of the object
   * @param y he y coordination of the location of the object
   */
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }
  /***
   * Getter for the x coordinate.
   *
   * @return x coordinate of the Location
   */
  public int getX() {
    return x;
  }
  /***
   * Getter for the y coordinate.
   *
   * @return y coordinate of the Location
   */
  public int getY() {
    return y;
  }

  /***
   * Equals method checks if two Location objects are equal based on their x and y coordinates.
   * If both coordinates are equal, the method returns true; otherwise, it returns false.
   * It overrides the Object class method.
   *
   * @param obj of type Object which we are comparing with the current Location object
   * @return boolean variable which is true if both objects are the same, otherwise false.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Location location = (Location) obj;
    return x == location.x && y == location.y;
  }
}
