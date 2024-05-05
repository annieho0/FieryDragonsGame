import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// represents 16 cards in the center of the volcano
// all should be implemented as circles facing downwards
// use random int generator to choose a token card

class TokenCard extends JPanel {
  private final int tileSize;
  private GameLogic gameLogic;
  // private String selectedToken;
//  private JPanel textPanel;
//  private JLabel textLabel1;
//  private JPanel mainPanel;

  public TokenCard(int tileSize, GameLogic gameLogic) {
    this.tileSize = tileSize;
    this.gameLogic = gameLogic;
    // this.selectedToken = "";
//    this.textPanel = textPanel;
//    this.textLabel1 = textLabel1;
//    this.mainPanel = mainPanel;
    // addMouseListener(new TokenClickListener());


  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.ORANGE);
    Random random = new Random();
    int tokensLength = gameLogic.getTokensLength();
    for (int i = 0; i < tokensLength; i++) {
      int circleDiameter = Math.min(tileSize / 2, tileSize / 2);
      int circleX = random.nextInt(5) + 2;
      int circleY = random.nextInt(5) + 2;
      circleX *= tileSize;
      circleY *= tileSize;
      g2d.fillOval(circleX, circleY, circleDiameter, circleDiameter);
//
//      // Create a JButton and set its bounds to the same as the circle
//      JButton button = new JButton();
//      button.setBounds(circleX, circleY, circleDiameter, circleDiameter);
//      button.setVisible(false);
//
//      // Add ActionListener to handle button click
//      button.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//          // Handle button click event
//          Random random = new Random();
//          int randomIndex = random.nextInt(tokens.length); // Generate a random index within the array length
//          selectedToken = tokens[randomIndex];
//          gameLogic.run(selectedToken);
//        }
//      });
//
//      // Add the button to the panel
//      mainPanel.add(button);
    }
  }

//  private class TokenClickListener extends MouseAdapter {
//    @Override
//    public void mouseClicked(MouseEvent e) {
//      Random random = new Random();
//      int randomIndex = random.nextInt(tokens.length); // Generate a random index within the array length
//      selectedToken = tokens[randomIndex];
//
////      JLabel text = new JLabel("You have selected: " + selectedToken); // Update the text label
////      // text.setFont(new Font("Arial", Font.BOLD, 18)); // Example font and size
////      text.setPreferredSize(new Dimension(800, 80)); // Set preferred size
////      text.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
////      text.setVerticalAlignment(SwingConstants.CENTER); // Center alignment
////      text.setVerticalTextPosition(SwingConstants.CENTER); // Center alignment
////      text.setHorizontalTextPosition(SwingConstants.CENTER); // Center alignment
////
////      // Remove all existing components from the textPanel
////      textPanel.removeAll();
////
////      textPanel.add(text); // Add the new text label
////      textPanel.revalidate(); // Revalidate the panel to reflect changes
////      textPanel.repaint(); // Repaint the panel
//
//      gameLogic.run(selectedToken);
//        }
//      }
    }