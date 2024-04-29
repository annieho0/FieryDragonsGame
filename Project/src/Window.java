import javax.swing.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame{
    private BufferStrategy bs;
    private GamePanel gamePanel;
    public Window() {
        setTitle("Fiery Dragons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        gamePanel = new GamePanel(); // Initialize the GamePanel
        getContentPane().add(gamePanel);
        pack();

        gamePanel.startGameThread();
    }

    public void addNotify() {
        super.addNotify();

        createBufferStrategy(2);
        bs = getBufferStrategy();


    }
}
