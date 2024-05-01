package main;

import main.UserInterface.GameUI;
import javax.swing.JFrame;
import java.awt.*;

public class Main extends JFrame {
    static int screenWidth = 1000;
    static int screenHeight = 800;

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setPreferredSize(new Dimension(screenWidth, screenHeight));
        window.setResizable(false);
        window.setTitle("Fiery Dragons");

        GameUI gameUI= new GameUI(screenWidth, screenHeight);
        window.add(gameUI);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

