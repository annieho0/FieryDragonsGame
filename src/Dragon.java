import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Dragon {
  public int col;
  public int row;
  public int xPos;
  public int yPos;
  public String name;
  private GameBoard gameBoard;
  public String imagePath;

  public Dragon(GameBoard gameBoard){
    this.gameBoard = gameBoard;
  }

  private boolean isAlive(){
    return true;
  }

}
