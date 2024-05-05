import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Dragon {
  private Location location;

  //  private int col;
//  private int row;
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

  public int getxPos() {
    return xPos;
  }

  public void setxPos(int xPos) {
    this.xPos = xPos;
  }

  public int getyPos() {
    return yPos;
  }

  public void setyPos(int yPos) {
    this.yPos = yPos;
  }
}
