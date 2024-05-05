import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class Cave extends JPanel {
  private final int tileSize;
  private int cols = 9;
  private int rows = 9;
  private int noOfCaves;
  private GameBoard gameBoard;
  ArrayList<Dragon> dragons = new ArrayList<>();
  public ArrayList<Animal> animals = new ArrayList<Animal>();
  public ArrayList<Integer> animalsXVals = new ArrayList<Integer>();

  public ArrayList<Integer> animalsYVals = new ArrayList<Integer>();

  public Cave(int tileSize, int noOfCaves, GameBoard gameBoard) {
    this.tileSize = tileSize;
    this.noOfCaves = noOfCaves;
    this.gameBoard = gameBoard;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;


    g2d.setColor(new Color(147, 123, 199));
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        int circleDiameter = Math.min(tileSize, tileSize);
        int circleX = c * tileSize;
        int circleY = r * tileSize;
        if (r == 1 && c == 4) {
          g2d.fillOval(circleX, circleY - circleDiameter / 2, circleDiameter, circleDiameter);
          Animal salamander = new Salamander(gameBoard,c,0);
          addAnimal(salamander, g2d, circleX, circleY - circleDiameter / 2);
          Dragon purpleDragon = new PurpleDragon(gameBoard, c, 0);
          addDragon(purpleDragon, g2d, circleX, circleY - circleDiameter / 2);
        } else if (r == 7 && c == 4) {
          g2d.setColor(new Color(184, 105, 203));
          g2d.fillOval(circleX, circleY + circleDiameter / 2, circleDiameter, circleDiameter);
          Animal bat = new Bat(gameBoard, c,8);
          addAnimal(bat, g2d, circleX, circleY + circleDiameter / 2);
          if (noOfCaves >= 2) {
            Dragon pinkDragon = new PinkDragon(gameBoard, c, 8);
            addDragon(pinkDragon, g2d, circleX, circleY + circleDiameter / 2);
          }
        } else if (c == 1 && r == 4) {
          g2d.setColor(new Color(97, 150, 206));
          g2d.fillOval(circleX - circleDiameter / 2, circleY, circleDiameter, circleDiameter);
          Animal spider = new Spider(gameBoard,0 ,r);
          addAnimal(spider, g2d, circleX - circleDiameter / 2, circleY);
          if (noOfCaves >= 3) {
            Dragon blueDragon = new BlueDragon(gameBoard, 0, r);
            addDragon(blueDragon, g2d, circleX - circleDiameter / 2, circleY);
          }
        } else if (c == 7 && r == 4) {
          g2d.setColor(new Color(129, 206, 134));
          g2d.fillOval(circleX + circleDiameter / 2, circleY, circleDiameter, circleDiameter);
          Animal babyDragon = new BabyDragon(gameBoard,8 ,r);
          addAnimal(babyDragon,  g2d, circleX + circleDiameter / 2, circleY);
          if (noOfCaves >= 4) {
            Dragon greenDragon = new GreenDragon(gameBoard, 8, r);
            addDragon(greenDragon, g2d, circleX + circleDiameter / 2, circleY);
          }

        }
      }
    }

  }

  private void addDragon(Dragon dragon, Graphics2D g2d, int xPos, int yPos){
    int width = tileSize / 3;
    int height = tileSize / 3;
    BufferedImage dragonImage = loadImage(dragon.getImagePath());
    drawImage(g2d,xPos - 15, yPos, dragonImage,width,height);
    dragons.add(dragon);
  }

  private void addAnimal(Animal animal, Graphics2D g2d, int xPos, int yPos){
    int width = tileSize / 3;
    int height = tileSize / 3;
    BufferedImage animalImage = loadImage(animal.imagePath);
    drawImage(g2d,xPos + 15, yPos, animalImage,width,height);
    animals.add(animal);
    animalsXVals.add(xPos);
    animalsYVals.add(xPos);
  }

  private BufferedImage loadImage(String imagePath) {
    try {
      return ImageIO.read(new File(imagePath));
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  private void drawImage(Graphics2D g2d, int xPos, int yPos, BufferedImage image, int width, int height) {
    // Calculate the position to center the resized image within the circle
    int imageX = xPos + (gameBoard.tileSize - width) / 2;
    int imageY = yPos + (gameBoard.tileSize - height) / 2;

    // Draw the resized image
    g2d.drawImage(image, imageX, imageY, width, height, null);
  }

}