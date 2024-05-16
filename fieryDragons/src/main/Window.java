package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.image.BufferStrategy;

/**
 * The Window class represents the main application window.
 */
public class Window extends JFrame {

    private BufferStrategy bs;
    private GamePanel gamePanel;
    private JFrame frame;
    //GameBoard gameBoard;
    JLabel textLabel1;
    JPanel textPanel;
    public String[] tokens = new String[16];
    private int noOfPlayers;
    JPanel mainPanel;


    /**
     * Constructs a Window object.
     */
    public Window() {
        initialise();
    }

    public void initialise(){
        frame = new JFrame();
        frame.setTitle("Fiery Dragons!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000,1000));
        frame.setLocationRelativeTo(null);


        // JPanel panel = new JPanel();
        JPanel panel = new ImagePanel("fieryDragons/res/image.png");
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
                    noOfPlayers = finalI;
                    gameBoardWindow(noOfPlayers);
//                    JFrame newFrame = new JFrame("Game Board");
//                    newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                    newFrame.setMinimumSize(new Dimension(1000, 1000));
//                    newFrame.setLocationRelativeTo(null);
//
//                    // Create a panel to hold the game board and text
//                    mainPanel = new JPanel(new BorderLayout());
//                    mainPanel.setPreferredSize(new Dimension(newFrame.getWidth(),800));
//
//                    // Create a panel for the text
//                    textPanel = new JPanel();
//                    textPanel.setPreferredSize(new Dimension(800, 200)); // Adjust the width and height as needed
//                    textPanel.setBackground(Color.LIGHT_GRAY); // Example background color
//
//                    // Create a label for the text
//                    textLabel1 = new JLabel("Click the button to randomly select a token!");
//                    textLabel1.setFont(new Font("Arial", Font.BOLD, 18)); // Example font and size
//                    textLabel1.setPreferredSize(new Dimension(800, 80)); // Set preferred size
//                    textLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment
//                    textLabel1.setVerticalAlignment(SwingConstants.CENTER); // Center alignment
//                    textLabel1.setVerticalTextPosition(SwingConstants.CENTER); // Center alignment
//                    textLabel1.setHorizontalTextPosition(SwingConstants.CENTER); // Center alignment
//
//                    JButton tokenButton = new JButton("Click Here");
//                    tokenButton.setVisible(true);
//
//                    tokenButton.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            Random random = new Random();
//                            int randomIndex = random.nextInt(tokens.length); // Generate a random index within the array length
//                            String selectedToken = tokens[randomIndex];
//                            // run(selectedToken);
//                        }
//                    });
                    // button.setBounds(x, y, width, height);

                    // textPanel.add(textLabel1);
                    // textPanel.add(tokenButton);
                    // textPanel.add(textLabel2);

                    // Add the text panel to the main panel on the south side
                    // mainPanel.add(textPanel, BorderLayout.SOUTH);

                    // Add the main panel to the frame
                    // newFrame.add(mainPanel);

                    // newFrame.setVisible(true);

                    // gameBoard = new GameBoard(finalI, GameLogic.this, mainPanel);

                    // gameBoard.construct();
                    // mainPanel.add(gameBoard);
                    // gameBoardWindow();
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

    public void gameBoardWindow(int noOfPlayers){
        setTitle("Fiery Dragons"); // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel(noOfPlayers);
        getContentPane().add(gamePanel);
        pack();
        gamePanel.setupGame();
        gamePanel.startGameThread();

        setVisible(true); // Make the window visible
    }


    /**
     * Overrides the addNotify method to create a buffer strategy for the window.
     */
    public void addNotify() {
        super.addNotify();

        createBufferStrategy(2);
        bs = getBufferStrategy();
    }

}
