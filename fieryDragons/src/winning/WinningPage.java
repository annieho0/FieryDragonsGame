package winning;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WinningPage extends JFrame {
    public WinningPage(String winningDragonColor) {
        super("Congratulations!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        Font pixelFont = null;
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/pixel.ttf");
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pixelFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        JLabel messageLabel = new JLabel("<html><div style='text-align: center; padding-top: 20px;'>Congratulations!<br/>" + winningDragonColor + " dragon has won!</div></html>");
        messageLabel.setFont(pixelFont);
        messageLabel.setForeground(Color.black);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel dragonPanel = new JPanel();
        dragonPanel.setBackground(new Color(0,0,0,0)); // Make the panel background transparent

        int dragonWidth = 100;
        int dragonHeight = 100;

        try {
            dragonPanel.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/players/BlueDragon.png")).getScaledInstance(dragonWidth, dragonHeight, Image.SCALE_DEFAULT))));
            dragonPanel.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/players/GreenDragon.png")).getScaledInstance(dragonWidth, dragonHeight, Image.SCALE_DEFAULT))));
            dragonPanel.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/players/PinkDragon.png")).getScaledInstance(dragonWidth, dragonHeight, Image.SCALE_DEFAULT))));
            dragonPanel.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/players/PurpleDragon.png")).getScaledInstance(dragonWidth, dragonHeight, Image.SCALE_DEFAULT))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JLabel backgroundLabel = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("/tiles/light_background.png")).getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
            backgroundLabel.setLayout(new BorderLayout());

            backgroundLabel.add(messageLabel, BorderLayout.NORTH);
            backgroundLabel.add(dragonPanel, BorderLayout.SOUTH);

            setContentPane(backgroundLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setVisible(true);
    }


}
