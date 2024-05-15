package main;

import javax.swing.*;
import java.awt.image.BufferStrategy;

/**
 * The Window class represents the main application window.
 */
public class Window extends JFrame {

    private BufferStrategy bs;
    private GamePanel gamePanel;

    /**
     * Constructs a Window object.
     */
    public Window() {
        setTitle("Fiery Dragons"); // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
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
