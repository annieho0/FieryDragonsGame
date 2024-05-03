import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

  private ArrayList<Dragon> dragons = new ArrayList<>();
  private int noOfPlayers;
  private GameLogic gameLogic;
  protected int tileSize = 85;
  private int cols = 9;
  private int rows = 9;
  private JPanel mainPanel;


  public GameBoard(int noOfPlayers, GameLogic gameLogic, JPanel mainPanel) {
    this.noOfPlayers = noOfPlayers;
    this.gameLogic = gameLogic;
    this.setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
    this.mainPanel = mainPanel;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // Always call super.paintComponent(g) first

    Graphics2D g2d = (Graphics2D) g;

    // Draw squares
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        Color c1 = (c + r) % 2 == 0 ? new Color(191, 150, 98) : new Color(115, 84, 60);

        if ((r >= 2 && r <= 6) && (c >= 2 && c <= 6)) {
          g2d.setColor(Color.BLACK);
        }
        if (r == 1 && (c > 0 && c < 8)) {
          g2d.setColor(c1);
        } else if (r == 7 && (c > 0 && c < 8)) {
          g2d.setColor(c1);

        } else if (c == 1 && (r > 0 && r < 8)) {
          g2d.setColor(c1);

        } else if (c == 7 && (r > 0 && r < 8)) {
          g2d.setColor(c1);

        }
        if (r == 0 || r == 8 || c == 0 || c == 8) {
          g2d.setColor(Color.WHITE);
        }

        g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);

        // add animal image on each volcano card
        Animal bat = new Bat(this);
        Animal spider = new Spider(this);
        Animal salamander = new Salamander(this);
        Animal babyDragon = new BabyDragon(this);
        Animal[] arr1 = {bat, spider, bat, spider, babyDragon, spider, salamander};
        Animal[] arr2 = {babyDragon, salamander, babyDragon, bat, bat};
        Animal[] arr3 = {babyDragon, salamander, spider, bat, salamander};
        Animal[] arr4 = {salamander, babyDragon, salamander, bat, spider, spider, babyDragon};

        addAnimal(arr1[0],g2d,1*tileSize+25,1*tileSize+25);
        addAnimal(arr1[1],g2d,2*tileSize,1*tileSize+25);
        addAnimal(arr1[2],g2d,3*tileSize,1*tileSize+25);
        addAnimal(arr1[3],g2d,4*tileSize,1*tileSize+25);
        addAnimal(arr1[4],g2d,5*tileSize,1*tileSize+25);
        addAnimal(arr1[5],g2d,6*tileSize,1*tileSize+25);
        addAnimal(arr1[6],g2d,7*tileSize-25,1*tileSize+25);

        addAnimal(arr2[0],g2d,1*tileSize+25,2*tileSize);
        addAnimal(arr2[1],g2d,1*tileSize+25,3*tileSize);
        addAnimal(arr2[2],g2d,1*tileSize+25,4*tileSize);
        addAnimal(arr2[3],g2d,1*tileSize+25,5*tileSize);
        addAnimal(arr2[4],g2d,1*tileSize+25,6*tileSize);

        addAnimal(arr3[0],g2d,7*tileSize-25,2*tileSize);
        addAnimal(arr3[1],g2d,7*tileSize-25,3*tileSize);
        addAnimal(arr3[2],g2d,7*tileSize-25,4*tileSize);
        addAnimal(arr3[3],g2d,7*tileSize-25,5*tileSize);
        addAnimal(arr3[4],g2d,7*tileSize-25,6*tileSize);

        addAnimal(arr4[0],g2d,1*tileSize+25,7*tileSize-25);
        addAnimal(arr4[1],g2d,2*tileSize,7*tileSize-25);
        addAnimal(arr4[2],g2d,3*tileSize,7*tileSize-25);
        addAnimal(arr4[3],g2d,4*tileSize,7*tileSize-25);
        addAnimal(arr4[4],g2d,5*tileSize,7*tileSize-25);
        addAnimal(arr4[5],g2d,6*tileSize,7*tileSize-25);
        addAnimal(arr4[6],g2d,7*tileSize-25,7*tileSize-25);
      }
    }

    Cave cave = new Cave(tileSize, noOfPlayers, this);
    cave.paintComponent(g);

    TokenCard token = new TokenCard(tileSize, gameLogic);
    token.paintComponent(g);

  }

  public void construct() {
    // Add the game board to the center of the main panel
    mainPanel.add(this, BorderLayout.CENTER);
  }

  private void addAnimal(Animal animal, Graphics2D g2d, int x, int y) {
    int width = tileSize / 3;
    int height = tileSize / 3;
    BufferedImage animalImage = loadImage(animal.imagePath);
    drawImage(g2d, x, y, animalImage, width, height);
  }

  private BufferedImage loadImage(String imagePath) {
    try {
      return ImageIO.read(new File(imagePath));
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  private void drawImage(Graphics2D g2d, int x, int y, BufferedImage image, int width, int height) {
    // Calculate the position to center the resized image within the circle
    int imageX = x + (tileSize - width) / 2;
    int imageY = y + (tileSize - height) / 2;

    // Draw the resized image
    g2d.drawImage(image, imageX, imageY, width, height, null);
  }
}


