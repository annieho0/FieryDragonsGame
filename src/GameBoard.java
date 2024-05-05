import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

  public ArrayList<Dragon> dragons = new ArrayList<>();
  private int noOfPlayers;
  private GameLogic gameLogic;
  protected int tileSize = 85;
  private int cols = 9;
  private int rows = 9;
  private JPanel mainPanel;

  private ArrayList<Animal> animals = new ArrayList<>();
  private ArrayList<Location> animalsLocations = new ArrayList<>();
  private ArrayList<Location> dragonsLocations = new ArrayList<>();


  public GameBoard(int noOfPlayers, GameLogic gameLogic, JPanel mainPanel) {
    this.noOfPlayers = noOfPlayers;
    this.gameLogic = gameLogic;
    this.mainPanel = mainPanel;
    this.setLayout(null);
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
        setOpaque(false);


        // caves
        if (r == 1 && c == 4) {
          int xPos = c * tileSize;
          int yPos = r * tileSize - tileSize / 2;
          Cave cave1 = new Cave(tileSize, new Color(147, 123, 199), xPos, yPos, c, r-1);
          cave1.paintComponent(g);
          Animal salamander = new Salamander(this,c,r-1);
          addAnimalForCave(salamander, g2d, xPos, yPos);
          Dragon purpleDragon = new PurpleDragon(this, c, r-1);
          // addDragon(purpleDragon, g2d, circleX, circleY - circleDiameter / 2);
          addDragon(purpleDragon, g2d, xPos, yPos);
          this.add(cave1);
          mainPanel.add(cave1);
          cave1.setVisible(true);
          cave1.setOpaque(true);
        }
        else if (r == 7 && c == 4) {
          int xPos = c * tileSize;
          int yPos = r * tileSize + tileSize / 2;
          Cave cave2 = new Cave(tileSize, new Color(184, 105, 203), xPos, yPos, c, r+1);
          cave2.paintComponent(g);
          Animal bat = new Bat(this, c,8);
          addAnimalForCave(bat, g2d, xPos, yPos);
          if (noOfPlayers >= 2) {
            Dragon pinkDragon = new PinkDragon(this, c, r+1);
            addDragon(pinkDragon, g2d, xPos, yPos);
          }
          this.add(cave2);
          mainPanel.add(cave2);
          cave2.setVisible(true);
          cave2.setOpaque(true);
        }
        else if (c == 7 && r == 4) {
          int xPos = c * tileSize + (tileSize/2);
          int yPos = r * tileSize;
          Cave cave4 = new Cave(tileSize, new Color(129, 206, 134), xPos, yPos, c+1, r);
          cave4.paintComponent(g);
          Animal babyDragon = new BabyDragon(this,c+1 ,r);
          addAnimalForCave(babyDragon,  g2d, xPos, yPos);
          if (noOfPlayers >= 4) {
            Dragon greenDragon = new GreenDragon(this, c+1, r);
            addDragon(greenDragon, g2d, xPos, yPos);
          }
          this.add(cave4);
          mainPanel.add(cave4);
          cave4.setVisible(true);
          cave4.setOpaque(true);
        }
        else if (c == 1 && r == 4) {
          int xPos = c * tileSize - (tileSize/2);
          int yPos = r * tileSize;
        Cave cave3 = new Cave(tileSize, new Color(97, 150, 206), xPos, yPos, c-1,r);
        cave3.paintComponent(g);
          Animal spider = new Spider(this,c-1 ,r);
          addAnimalForCave(spider, g2d,xPos, yPos);
          if (noOfPlayers >= 3) {
            Dragon blueDragon = new BlueDragon(this, c-1, r);
            addDragon(blueDragon, g2d, xPos, yPos);
          }
           this.add(cave3);
           mainPanel.add(cave3);
          cave3.setVisible(true);
          cave3.setOpaque(true);
        }
    }
  }

    // add animal image on each volcano card
    // top row
    int bat1col = 1;
    int bat1row = 1;
    Animal bat1 = new Bat(this, bat1col,bat1row);
    addAnimal(bat1,g2d,bat1col*tileSize+25,bat1row*tileSize+25);
    int spider1col = 2;
    int spider1row = 1;
    Animal spider1 = new Spider(this, spider1col, spider1row);
    addAnimal(spider1,g2d,spider1col*tileSize,spider1row*tileSize+25);
    int bat2col = 3;
    int bat2row = 1;
    Animal bat2 = new Bat(this, bat2col,bat2row);
    addAnimal(bat2,g2d,bat2col*tileSize,bat2row*tileSize+25);
    int spider2col = 4;
    int spider2row = 1;
    Animal spider2 = new Spider(this, spider2col, spider2row);
    addAnimal(spider2,g2d,spider2col*tileSize,spider2row*tileSize+25);
    int babyDragon1col = 5;
    int babyDragon1row = 1;
    Animal babyDragon1 = new BabyDragon(this, babyDragon1col, babyDragon1row);
    addAnimal(babyDragon1,g2d,babyDragon1col*tileSize,babyDragon1row*tileSize+25);
    int spider3col = 6;
    int spider3row = 1;
    Animal spider3 = new Spider(this, spider3col, spider3row);
    addAnimal(spider3,g2d,spider3col*tileSize,spider3row*tileSize+25);
    int salamander1col = 7;
    int salamander1row = 1;
    Animal salamander1 = new Salamander(this, salamander1col, salamander1row);
    addAnimal(salamander1,g2d,salamander1col*tileSize-25,salamander1row*tileSize+25);
    // lhs column
    int babyDragon2col = 1;
    int babyDragon2row = 2;
    Animal babyDragon2 = new BabyDragon(this, babyDragon2col, babyDragon2row);
    addAnimal(babyDragon2,g2d,babyDragon2col*tileSize+25,babyDragon2row*tileSize);
    int salamander2col = 1;
    int salamander2row = 3;
    Animal salamander2 = new Salamander(this, salamander2col, salamander2row);
    addAnimal(salamander2,g2d,salamander2col*tileSize+25,salamander2row*tileSize);
    int babyDragon3col = 1;
    int babyDragon3row = 4;
    Animal babyDragon3 = new BabyDragon(this, babyDragon3col, babyDragon3row);
    addAnimal(babyDragon3,g2d,babyDragon3col*tileSize+25,babyDragon3row*tileSize);
    int bat3col = 1;
    int bat3row = 5;
    Animal bat3 = new Bat(this, bat3col,bat3row);
    addAnimal(bat3,g2d,bat3col*tileSize+25,bat3row*tileSize);
    int bat4col = 1;
    int bat4row = 6;
    Animal bat4 = new Bat(this, bat4col,bat4row);
    addAnimal(bat4,g2d,bat4col*tileSize+25,bat4row*tileSize);
    // rhs column
    int babyDragon4col = 7;
    int babyDragon4row = 2;
    Animal babyDragon4 = new BabyDragon(this, babyDragon4col, babyDragon4row);
    addAnimal(babyDragon4,g2d,babyDragon4col*tileSize-25,babyDragon4row*tileSize);
    int salamander3col = 7;
    int salamander3row = 3;
    Animal salamander3 = new Salamander(this, salamander3col, salamander3row);
    addAnimal(salamander3,g2d,salamander3col*tileSize-25,salamander3row*tileSize);
    int spider4col = 7;
    int spider4row = 4;
    Animal spider4 = new Spider(this, spider4col, spider4row);
    addAnimal(spider4,g2d,spider4col*tileSize-25,spider4row*tileSize);
    int bat5col = 7;
    int bat5row = 5;
    Animal bat5 = new Bat(this, bat5col,bat5row);
    addAnimal(bat5,g2d,bat5col*tileSize-25,bat5row*tileSize);
    int salamander4col = 7;
    int salamander4row = 6;
    Animal salamander4 = new Salamander(this, salamander4col, salamander4row);
    addAnimal(salamander4,g2d,salamander4col*tileSize-25,salamander4row*tileSize);

    // bottom row
    int salamander5col = 1;
    int salamander5row = 7;
    Animal salamander5 = new Salamander(this, salamander5col, salamander5row);
    addAnimal(salamander5,g2d,salamander5col*tileSize+25,salamander5row*tileSize-25);
    int babyDragon5col = 2;
    int babyDragon5row = 7;
    Animal babyDragon5 = new BabyDragon(this, babyDragon5col, babyDragon5row);
    addAnimal(babyDragon5,g2d,babyDragon5col*tileSize,babyDragon5row*tileSize-25);
    int salamander6col = 3;
    int salamander6row = 7;
    Animal salamander6 = new Salamander(this, salamander6col, salamander6row);
    addAnimal(salamander6,g2d,salamander6col*tileSize,salamander6row*tileSize-25);
    int bat6col = 4;
    int bat6row = 7;
    Animal bat6 = new Bat(this, bat6col,bat6row);
    addAnimal(bat6,g2d,bat6col*tileSize,bat6row*tileSize-25);
    int spider5col = 5;
    int spider5row = 7;
    Animal spider5 = new Spider(this, spider5col, spider5row);
    addAnimal(spider5,g2d,spider5col*tileSize,spider5row*tileSize-25);
    int spider6col = 6;
    int spider6row = 7;
    Animal spider6 = new Spider(this, spider6col, spider6row);
    addAnimal(spider6,g2d,spider6col*tileSize,spider6row*tileSize-25);
    int babyDragon6col = 7;
    int babyDragon6row = 7;
    Animal babyDragon6 = new BabyDragon(this, babyDragon6col, babyDragon6row);
    addAnimal(babyDragon6,g2d,babyDragon6col*tileSize-25,babyDragon6row*tileSize-25);


    TokenCard token = new TokenCard(tileSize, gameLogic);
    token.paintComponent(g);
    mainPanel.add(token);
  }


  public void construct() {
    // Add the game board to the center of the main panel
    mainPanel.add(this, BorderLayout.CENTER);

  }

  private void addAnimal(Animal animal, Graphics2D g2d, int xPos, int yPos) {
    int width = tileSize / 3;
    int height = tileSize / 3;
    BufferedImage animalImage = loadImage(animal.imagePath);
    drawImage(g2d, xPos, yPos, animalImage, width, height);
    animals.add(animal);
    animalsLocations.add(animal.getLocation());
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
    int imageX = xPos + (tileSize - width) / 2;
    int imageY = yPos + (tileSize - height) / 2;

    // Draw the resized image
    g2d.drawImage(image, imageX, imageY, width, height, null);
  }

  public Dragon getDragon(Location location) {
    for (Dragon dragon : dragons) {
      if (dragon.getLocation().equals(location)) {
        return dragon;
      }
    }
    return null;
  }

  public ArrayList<Dragon> getDragons() {
    return dragons;
  }

  private void addAnimalForCave(Animal animal, Graphics2D g2d, int xPos, int yPos){
    int width = tileSize / 3;
    int height = tileSize / 3;
    BufferedImage animalImage = loadImage(animal.imagePath);
    drawImage(g2d,xPos + 15, yPos, animalImage,width,height);
    animals.add(animal);
    animalsLocations.add(animal.getLocation());
  }


  private void addDragon(Dragon dragon, Graphics2D g2d, int xPos, int yPos){
    int width = tileSize / 3;
    int height = tileSize / 3;
    BufferedImage dragonImage = loadImage(dragon.getImagePath());
    drawImage(g2d,xPos - 15, yPos, dragonImage,width,height);
    dragons.add(dragon);
    dragonsLocations.add(dragon.getLocation());
  }

  public ArrayList<Animal> getAnimals() {
    return animals;
  }

  public ArrayList<Location> getAnimalsLocations() {
    return animalsLocations;
  }
}


