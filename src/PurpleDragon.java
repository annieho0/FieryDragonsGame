public class PurpleDragon extends Dragon {

  public PurpleDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard);
    this.col = col;
    this.row = row;
    this.xPos = col*gameBoard.tileSize;
    this.yPos = row*gameBoard.tileSize;
    this.name = "Purple Dragon";
    this.imagePath = "src/images/purpledragon.jpeg";
  }

}
