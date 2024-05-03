import dragons.BlueDragon;
import dragons.Dragon;
import dragons.GreenDragon;
import dragons.PinkDragon;
import dragons.PurpleDragon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// assembles all the volcano cards and token cards and caves
public class GameBoard extends JPanel{
  private Dragon[] dragons;
  private int noOfPlayers;
  // private VolcanoCard[][] volcanoCards;
  private GameLogic gameLogic;
  private int tileSize = 85;
  private int cols = 9;
  private int rows = 9;
  private JPanel mainPanel;


  public GameBoard(int noOfPlayers, GameLogic gameLogic, JPanel mainPanel){
    this.noOfPlayers = noOfPlayers;
    this.gameLogic = gameLogic;
    dragons = new Dragon[]{new BlueDragon(),new PinkDragon(), new PurpleDragon(), new GreenDragon()};
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

        if ((r >= 2 && r <= 6) && (c >= 2 && c <= 6)){
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
        if (r == 0 || r == 8 || c == 0 || c == 8){
          g2d.setColor(Color.WHITE);
        }

        g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
      }
    }

    Cave cave = new Cave(tileSize, noOfPlayers);
    cave.paintComponent(g);

    TokenCard token = new TokenCard(tileSize, gameLogic);
    token.paintComponent(g);
  }

  public void construct(){
    // open new page with four player game board here
//    JFrame newFrame = new JFrame("Game Board");
//    newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    newFrame.setMinimumSize(new Dimension(1000,1000));
//    newFrame.setLocationRelativeTo(null);

    // Add the GameBoard instance directly to the frame
    //newFrame.add(this);
    //newFrame.setVisible(true);
    //newFrame.setLayout(null);

    // Create a panel to hold the game board and text
    // JPanel mainPanel = new JPanel(new BorderLayout());

    // Add the game board to the center of the main panel
    mainPanel.add(this, BorderLayout.CENTER);


  }

//    for (int i = 0; i < noOfPlayers; i++){
//      // add as many dragons as players, one on each cave
//    }
//
//    JPanel outerPanel = new JPanel();
//    outerPanel.setSize(500, 500);
//
//// Create a panel for the bordered grid layout
//    JPanel borderedPanel = new JPanel(new GridLayout(8,8));
//
//    for (int i = 0; i < 49; i++) {
//      JPanel squarePanel = new JPanel(); // Create a panel for each square
//      // Add a border only to the outer perimeter squares
//      if (i < 7 || i % 7 == 0 || i % 7 == 6 || i >= 42) {
//        squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//      }
//      borderedPanel.add(squarePanel); // Add the square panel to the bordered panel
//
//      // Add the circle to the desired square (e.g., index 24)
//      if (i == 0 || i == 6 || i == 42 || i == 48) {
//        squarePanel.setLayout(new BorderLayout());
//        Cave cave = new Cave();
//        cave.setBounds(150,200,50,50);
//        // outerPanel.add(cave);
//        cave.setVisible(true);
//        squarePanel.add(cave); // Add the circle to the right of the square
//      }
//    }
//
//    outerPanel.add(borderedPanel);
//
//    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    buttonPanel.setPreferredSize(new Dimension(800, 40));
//
//    // Add buttons to the button panel
//    JButton startButton = new JButton("Start Game!");
//    startButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//        gameLogic.run(noOfPlayers);
//      }
//    });
//
//    buttonPanel.add(startButton);
//
//// Add the button panel to the bottom of the outer panel
//    outerPanel.add(buttonPanel, BorderLayout.SOUTH);
//
//// Add the outer panel to the newFrame
//    newFrame.add(outerPanel);

    // need images on each volcano card
    // need image on each cave
    // need 16 token cards in the centre

  }
