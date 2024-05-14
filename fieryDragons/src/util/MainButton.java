package util;

import main.GameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainButton extends JButton{
        public MainButton(String label) {
            super(label);
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (getText().equals("EXIT")) {
                        System.exit(0);
                    }
                    if (getText().equals("LOAD GAME")) {
                        // Reference to current frame
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MainButton.this);
                        frame.getContentPane().removeAll();
                        GameWindow gameWindow = new GameWindow();
                        frame.getContentPane().add(gameWindow);
                    }
                }
            });
        }
    }
