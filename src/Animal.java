/**
 * Abstract Animal class represents an animal on the volcano cards and the dragon cards.
 * They have the attributes location which states their image on the GameBoard,
 * imagePath which is the link the image of the animal,
 * the name of the animal as a String
 * and the GameBoard variable.
 *
 * Created by:
 * @author Navya Balraj
 */
public abstract class Animal {
  private Location location;
  public String imagePath;
  public String name;
  private GameBoard gameBoard;
  /***
   * Constructor for Animal class.
   *
   * @param gameBoard the Gameboard the Animal is on
   * @param initialX the x value of the location of the animal
   * @param initialY the y value of the location of the animal
   * @param name of the Animal
   * @param imagePath link where the image of the Animal is
   */
  public Animal(GameBoard gameBoard, int initialX, int initialY, String name, String imagePath){
    this.gameBoard = gameBoard;
    this.location = new Location(initialX, initialY);
    this.name = name;
    this.imagePath = imagePath;
  }

  /**
   * Getter for the Location variable.
   *
   * @return Location of the Animal
   */
  public Location getLocation() {
    return location;
  }
}
