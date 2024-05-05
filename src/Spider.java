public class Spider extends Animal {

  public Spider(GameBoard gameBoard, int col, int row) {
    super(gameBoard, col * gameBoard.tileSize, row * gameBoard.tileSize, "Spider", "src/images/spider.jpeg");
//    this.name = "Spider";
//    this.imagePath = "src/images/spider.jpeg";
  }
}
