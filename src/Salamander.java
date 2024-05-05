public class Salamander extends Animal{

  public Salamander(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col * gameBoard.tileSize, row * gameBoard.tileSize, "Salamander", "src/images/salamander.jpeg");
//    this.name = "Salamnder";
//    this.imagePath = "src/images/salamander.jpeg";
  }
}
