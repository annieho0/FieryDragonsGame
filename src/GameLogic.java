import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class GameLogic {
  private JFrame frame;
  GameBoard gameBoard;
  JLabel textLabel1;
  JPanel textPanel;
  public String[] tokens = new String[16];
  private int noOfPlayers;
  JPanel mainPanel;


  public GameLogic(){
    initialize();
    this.gameBoard = null;
    noOfPlayers = 0;
    // initialise tokens array
    tokens[0] = "1 Salamander";
    tokens[1] = "2 Salamanders";
    tokens[2] = "3 Salamanders";
    tokens[3] = "1 Bat";
    tokens[4] = "2 Bats";
    tokens[5] = "3 Bats";
    tokens[6] = "1 Spider";
    tokens[7] = "2 Spiders";
    tokens[8] = "3 Spiders";
    tokens[9] = "1 Baby Dragon";
    tokens[10] = "2 Baby Dragons";
    tokens[11] = "3 Baby Dragons";
    tokens[12] = "1 Pirate Dragon";
    tokens[13] = "1 Pirate Dragon";
    tokens[14] = "2 Pirate Dragons";
    tokens[15] = "2 Pirate Dragons";
  }

  public void initialize(){
    frame = new JFrame();
    frame.setTitle("Fiery Dragons!");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setMinimumSize(new Dimension(1000,1000));
    frame.setLocationRelativeTo(null);


    // JPanel panel = new JPanel();
    JPanel panel = new ImagePanel("src/images/image.png");
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    panel.setBackground(Color.decode("#FF0000"));

    JPanel panel1 = new JPanel();
    panel1.setOpaque(false);
    panel1.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
    panel1.setPreferredSize(new Dimension(800, 500));
    JLabel heading = new JLabel("FIERY DRAGONS!");
    heading.setFont(new Font("Arial", Font.BOLD,38));
    panel1.add(heading);

    JPanel panel2 = new JPanel();
    panel2.setOpaque(false);
    panel2.setPreferredSize(new Dimension(800, 50));
    JLabel question = new JLabel("How many Players would you like to play with?");
    question.setFont(new Font("Arial", Font.BOLD,28));

    panel2.add(question);

    JPanel panel3 = new JPanel();
    panel3.setOpaque(false);
    panel3.setPreferredSize(new Dimension(800, 30));

    // select number of players buttons and construction of game board
    for (int i = 0; i < 3; i++){
      int finalI = i+2;
      JButton button = new JButton(finalI + " Players");
      int finalI1 = i;
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          noOfPlayers = finalI1;
          JFrame newFrame = new JFrame("Game Board");
          newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          newFrame.setMinimumSize(new Dimension(1000, 1000));
          newFrame.setLocationRelativeTo(null);

          // Create a panel to hold the game board and text
          mainPanel = new JPanel(new BorderLayout());

          // Create a panel for the text
          textPanel = new JPanel();
          textPanel.setPreferredSize(new Dimension(800, 200)); // Adjust the width and height as needed
          textPanel.setBackground(Color.LIGHT_GRAY); // Example background color

          // Create a label for the text
          textLabel1 = new JLabel("Click the button to randomly select a token!");
          textLabel1.setFont(new Font("Arial", Font.BOLD, 18)); // Example font and size
          textLabel1.setPreferredSize(new Dimension(800, 80)); // Set preferred size
          textLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
          textLabel1.setVerticalAlignment(SwingConstants.CENTER); // Center alignment
          textLabel1.setVerticalTextPosition(SwingConstants.CENTER); // Center alignment
          textLabel1.setHorizontalTextPosition(SwingConstants.CENTER); // Center alignment

          // textLabel2 = new JLabel();
          // JButton button = new JButton("Click Here to randomly Select a Token from the centre of the Game Board");
          JButton tokenButton = new JButton("Click Here");
          tokenButton.setVisible(true);

          tokenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Random random = new Random();
              int randomIndex = random.nextInt(tokens.length); // Generate a random index within the array length
              String selectedToken = tokens[randomIndex];
             run(selectedToken);
            }
          });
          // button.setBounds(x, y, width, height);

          textPanel.add(textLabel1);
          textPanel.add(tokenButton);
          // textPanel.add(textLabel2);

          // Add the text panel to the main panel on the south side
          mainPanel.add(textPanel, BorderLayout.SOUTH);

          // Add the main panel to the frame
          newFrame.add(mainPanel);

          newFrame.setVisible(true);

          gameBoard = new GameBoard(finalI, GameLogic.this, mainPanel, textPanel, textLabel1);

          gameBoard.construct();
          frame.dispose();
        }
      });
      panel3.add(button);
    }

    panel.add(panel1);
    panel.add(panel2);
    panel.add(panel3);
    frame.add(panel, BorderLayout.CENTER);

    frame.setVisible(true);
  }

  public int getTokensLength(){
    return tokens.length;
  }

  public void run(String selectedToken){
    JLabel text = new JLabel("You have selected a token with: " + selectedToken);
    text.setFont(new Font("Arial", Font.BOLD, 18)); // Example font and size
    text.setPreferredSize(new Dimension(800, 80)); // Set preferred size
    text.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
    text.setVerticalAlignment(SwingConstants.CENTER); // Center alignment
    text.setVerticalTextPosition(SwingConstants.CENTER); // Center alignment
    text.setHorizontalTextPosition(SwingConstants.CENTER); // Center alignment
    textPanel.removeAll();
    textPanel.add(text); // Add the new text label
    textPanel.revalidate(); // Revalidate the panel to reflect changes
    textPanel.repaint(); // Repaint the panel


    // if dragon card selected has the same animal as where the dragon stands (cave) they can move that many squares.
    // use movement action
    // use random int generator again for that player.
    // if dragon card doesnt match position, it is the next dragons turn, use random int generator again
    ArrayList<Dragon> dragons = gameBoard.getDragons();
    Dragon selectedDragon = dragons.get(0);
    selectedDragon.setLocation(new Location (1,1));

//    Action move = new MovementAction(gameBoard, selectedDragon, 1, 1 ,
//        gameBoard.tileSize);
//    move.execute();
    mainPanel.repaint();


    // start with one dragon. selected dragon is the parameter of this function
//    for (int i = 0; i < noOfPlayers; i++){
//    ArrayList<Integer> differenceX = new ArrayList<Integer>();;
//    ArrayList<Integer> differenceY = new ArrayList<Integer>();;
//    Animal animalOnSquare = null;
//    int newCol = 0;
//    int newRow = 0;
//    int moves = 0;
//      for (int i = 0; i < gameBoard.animalsXVals.size(); i++){
//        differenceX.add(gameBoard.animalsXVals.get(i) - dragons.get(0).xPos);
//        differenceY.add(gameBoard.animalsYVals.get(i) - dragons.get(0).yPos);
//      }
//    for (int i = 0; i < gameBoard.animalsYVals.size(); i++){
//      if (differenceY.get(i) < Math.abs(50) && differenceX.get(i) < Math.abs(50)){
//        // dragon is on a square with this animal
//        animalOnSquare = gameBoard.animals.get(i);
//       break;
//      }
//    }
//        if (selectedToken.contains(animalOnSquare.name)){
//          if (moves == 0){
//            newCol = dragons.get(0).yPos - 30;
//            newRow = dragons.get(0).xPos;
//          } else if (moves >= 1 && moves <=3) {
//            newCol = dragons.get(0).yPos;
//            newRow = dragons.get(0).xPos + 85;
//          }
//          Action move = new MovementAction(gameBoard, selectedDragon, newCol, newRow,
//              gameBoard.tileSize);
//        move.execute();
//        moves++;
//        mainPanel.repaint();
//        text.setText("You have moved from the " + selectedToken.substring(2) + ". Click button again to select another token!");
//          JButton tokenButton = new JButton("Click Here");
//          tokenButton.setVisible(true);
//
//          tokenButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//              Random random = new Random();
//              int randomIndex = random.nextInt(tokens.length); // Generate a random index within the array length
//              String selectedToken = tokens[randomIndex];
//              run(selectedToken);
//            }
//          });
//          textPanel.add(tokenButton);
//        } else {
//      text.setText("Since you are not standing on a " + selectedToken.substring(2) + " you cannot move yet");
//          JButton tokenButton = new JButton("Click Here");
//          tokenButton.setVisible(true);
//
//          tokenButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//              Random random = new Random();
//              int randomIndex = random.nextInt(tokens.length); // Generate a random index within the array length
//              String selectedToken = tokens[randomIndex];
//              run(selectedToken);
//            }
//          });
//          textPanel.add(tokenButton);
//    }
  }

}

