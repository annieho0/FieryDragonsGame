package main;

import main.GamePanel;

import javax.swing.*;
import java.awt.image.BufferStrategy;

public class Window extends JFrame {

    private BufferStrategy bs;
    private GamePanel gamePanel;

    public Window() {
        setTitle("Fiery Dragons");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel(); // Initialize the GamePanel
        getContentPane().add(gamePanel);
        pack();

        gamePanel.setupGame();
        gamePanel.startGameThread();

        setVisible(true);
    }

    public void addNotify() {
        super.addNotify();

        createBufferStrategy(2);
        bs = getBufferStrategy();


    }

}