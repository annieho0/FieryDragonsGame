package main;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
        static int screenWidth = 1000;
        static int screenHeight = 800;

        private MainPanel mainPanel;
        public MainWindow() {
            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setPreferredSize(new Dimension(screenWidth, screenHeight));
            window.setResizable(false);
            window.setTitle("Fiery Dragons");

            mainPanel = new MainPanel(screenWidth, screenHeight);
            window.add(mainPanel);
            window.pack();

            window.setLocationRelativeTo(null);
            window.setVisible(true);
        }
    }


