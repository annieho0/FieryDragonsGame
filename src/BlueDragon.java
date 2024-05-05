public class BlueDragon extends Dragon {

  public BlueDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Blue Dragon", "src/images/bluedragon.jpeg", col*gameBoard.tileSize, row*gameBoard.tileSize);
  }
}
