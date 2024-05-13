package winning;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class WinningPage extends JFrame {
    Window window;
    public WinningPage() {
        // Set up the JFrame
        super("Congratulations!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setLocationRelativeTo(window); // Center the window on the screen

        // Create and customize the winning message label
        JLabel messageLabel = new JLabel("Congratulations! You have won the game!");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setVerticalAlignment(JLabel.CENTER);

        // Add the message label to the JFrame
        getContentPane().add(messageLabel);

        // Make the JFrame visible
        setVisible(true);
    }

}

