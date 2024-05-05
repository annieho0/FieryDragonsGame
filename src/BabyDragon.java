public class BabyDragon extends Animal{

  public BabyDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col * gameBoard.tileSize, row * gameBoard.tileSize, "Baby Dragon", "src/images/babydragon.jpeg");
//    this.name = "Baby Dragon";
//    this.imagePath = "src/images/babydragon.jpeg";
  }
}
