import dragons.Dragon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameLogic {
  private JFrame frame;
  GameBoard gameBoard;
  JLabel textLabel1;
  JLabel textLabel2;

  public GameLogic(){
    initialize();
    this.gameBoard = null;
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
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          JFrame newFrame = new JFrame("Game Board");
          newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          newFrame.setMinimumSize(new Dimension(1000, 1000));
          newFrame.setLocationRelativeTo(null);

          // Create a panel to hold the game board and text
          JPanel mainPanel = new JPanel(new BorderLayout());

          // Create a panel for the text
          JPanel textPanel = new JPanel();
          textPanel.setPreferredSize(new Dimension(800, 200)); // Adjust the width and height as needed
          textPanel.setBackground(Color.LIGHT_GRAY); // Example background color

          // Create a label for the text
          textLabel1 = new JLabel("Select any token in the centre of the Game Board to begin!");
          textLabel1.setFont(new Font("Arial", Font.BOLD, 18)); // Example font and size
          textLabel1.setPreferredSize(new Dimension(800, 80)); // Set preferred size
          textLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
          textLabel1.setVerticalAlignment(SwingConstants.CENTER); // Center alignment
          textLabel1.setVerticalTextPosition(SwingConstants.CENTER); // Center alignment
          textLabel1.setHorizontalTextPosition(SwingConstants.CENTER); // Center alignment

          textLabel2 = new JLabel();

          textPanel.add(textLabel1);
          textPanel.add(textLabel2);

          // Add the text panel to the main panel on the south side
          mainPanel.add(textPanel, BorderLayout.SOUTH);

          // Add the main panel to the frame
          newFrame.add(mainPanel);

          newFrame.setVisible(true);

          gameBoard = new GameBoard(finalI, GameLogic.this, mainPanel);

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




  public void run(TokenCard selectedToken){
    textLabel1.setText("You have selected a " + selectedToken);
    textLabel2.setText("Since you are standing on .. you cannot move yet");
    // start with one dragon. selected dragon is the parameter of this function
    //for (int i = 0; i < noOfPlayers; i++){
//      if (dragons[i].isAlive){
//        // processPlayerTurn(dragons[i]);
//      }

    //}
  }

  public void processPlayerTurn(Dragon dragon){
// use random int generator to select one of the 16 token cards
    // if dragon card selected has the same animal as where the dragon stands (cave) they can move that many squares.
    // use movement action
    // use random int generator again for that player.
    // if dragon card doesnt match position, it is the next dragons turn, use random int generator again
  }

}

