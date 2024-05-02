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

public class GameLogic {
  private JFrame frame;
  GameBoard gameBoard;

  public GameLogic(){
    initialize();
    this.gameBoard = null;
  }

  public void initialize(){
    frame = new JFrame();
    frame.setTitle("Fiery Dragons!");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800,500);
    frame.setLocationRelativeTo(null);


    // JPanel panel = new JPanel();
    JPanel panel = new ImagePanel("src/images/image.png");
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    panel.setBackground(Color.decode("#FF0000"));

    JPanel panel1 = new JPanel();
    panel1.setOpaque(false);
    panel1.setLayout(new FlowLayout(FlowLayout.CENTER,10,50));
    panel1.setPreferredSize(new Dimension(800, 200));
    JLabel heading = new JLabel("FIERY DRAGONS!");
    heading.setFont(new Font("Arial", Font.BOLD,38));
    panel1.add(heading);

    JPanel panel2 = new JPanel();
    panel2.setOpaque(false);
    panel2.setPreferredSize(new Dimension(800, 30));
    JLabel question = new JLabel("How many Players would you like to play with?");
    question.setFont(new Font("Arial", Font.BOLD,28));

    panel2.add(question);

    JPanel panel3 = new JPanel();
    panel3.setOpaque(false);
    panel3.setPreferredSize(new Dimension(800, 60));

    // select number of players buttons and construction of game board
    for (int i = 0; i < 3; i++){
      int finalI = i+2;
      JButton button = new JButton(finalI + " Players");
      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          gameBoard = new GameBoard(finalI, GameLogic.this);
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




  public void run(){


//    for (Actor actor : actorLocations) {
//      if (stillRunning())
//        processActorTurn(actor);
//    }
  }

  protected void processPlayerTurn(Player player){

  }

}

