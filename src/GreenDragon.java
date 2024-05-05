public class GreenDragon extends Dragon {
  public GreenDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col, row, "Green Dragon", "src/images/greendragon.jpeg", col*gameBoard.tileSize, row*gameBoard.tileSize);
  }
}
