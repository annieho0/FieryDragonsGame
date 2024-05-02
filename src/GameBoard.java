import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// assembles all the volcano cards and token cards and caves
public class GameBoard extends JPanel{
  private int noOfPlayers;
  // private VolcanoCard[][] volcanoCards;
  private GameLogic gameLogic;


  public GameBoard(int noOfPlayers, GameLogic gameLogic){
    this.noOfPlayers = noOfPlayers;
    this.gameLogic = gameLogic;
      }

  public void construct(){
    // open new page with four player game board here
    JFrame newFrame = new JFrame("Game Board");
    newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    newFrame.setSize(800, 500);
    newFrame.setLocationRelativeTo(null);
    newFrame.setVisible(true);

    JPanel outerPanel = new JPanel();
    outerPanel.setSize(500, 500);

// Create a panel for the bordered grid layout
    JPanel borderedPanel = new JPanel(new GridLayout(7,7));

    for (int i = 0; i < 49; i++) {
      JPanel squarePanel = new JPanel(); // Create a panel for each square
      // Add a border only to the outer perimeter squares
      if (i < 7 || i % 7 == 0 || i % 7 == 6 || i >= 42) {
        squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      }
      borderedPanel.add(squarePanel); // Add the square panel to the bordered panel

      // Add the circle to the desired square (e.g., index 24)
      if (i == 0) {
        squarePanel.setLayout(new BorderLayout());
        Cave cave = new Cave();
        cave.setBounds(100,200,50,50);
        // outerPanel.add(cave);
        squarePanel.add(cave, BorderLayout.LINE_END); // Add the circle to the right of the square
      }
    }

    outerPanel.add(borderedPanel);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.setPreferredSize(new Dimension(800, 40));

    // Add buttons to the button panel
    JButton startButton = new JButton("Start Game!");
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        gameLogic.run();
      }
    });

    buttonPanel.add(startButton);

// Add the button panel to the bottom of the outer panel
    outerPanel.add(buttonPanel, BorderLayout.SOUTH);

// Add the outer panel to the newFrame
    newFrame.add(outerPanel);
  }
}
