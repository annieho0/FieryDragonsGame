public class PinkDragon extends Dragon {

  public PinkDragon(GameBoard gameBoard, int col, int row) {
    super(gameBoard);
    this.col = col;
    this.row = row;
    this.xPos = col*gameBoard.tileSize;
    this.yPos = row*gameBoard.tileSize;
    this.name = "Pink Dragon";
    this.imagePath = "src/images/pinkdragon.jpeg";
  }

}
