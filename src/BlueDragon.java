public class BlueDragon extends Dragon {

  public BlueDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard);
    this.col = col;
    this.row = row;
    this.xPos = col*gameBoard.tileSize;
    this.yPos = row*gameBoard.tileSize;
    this.name = "Blue Dragon";
    this.imagePath = "src/images/bluedragon.jpeg";
  }
}
