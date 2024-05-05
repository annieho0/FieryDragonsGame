import java.util.ArrayList;

public class Bat extends Animal{

  public ArrayList<Integer> batXVals;
  public ArrayList<Integer> batYVals;


  public Bat(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col * gameBoard.tileSize, row * gameBoard.tileSize, "Bat", "src/images/bat.jpeg");
//    this.name = "Bat";
//    this.imagePath = "src/images/bat.jpeg";
  }
}
