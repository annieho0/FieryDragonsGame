public class GreenDragon extends Dragon {
  public GreenDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard);
    this.col = col;
    this.row = row;
    this.xPos = col*gameBoard.tileSize;
    this.yPos = row*gameBoard.tileSize;
    this.name = "Green Dragon";
    this.imagePath = "src/images/greendragon.jpeg";
  }

}
