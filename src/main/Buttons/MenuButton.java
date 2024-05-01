package main.Buttons;

import main.UserInterface.GameUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuButton extends JButton {

    public MenuButton(String label) {
        super(label);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (getText().equals("BACK")) {
                    GameUI gameUI = new GameUI(1000, 800);

                    // Reference to current frame
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MenuButton.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameUI);
                    frame.revalidate();
                    frame.repaint();
                }

                if (getText().equals("2 PLAYERS")) {
                    GameUI gameUI = new GameUI(1000, 800);

                    // Reference to current frame
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MenuButton.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameUI);
                    frame.revalidate();
                    frame.repaint();
                }

                if (getText().equals("3 PLAYERS")) {
                    GameUI gameUI = new GameUI(1000, 800);

                    // Reference to current frame
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MenuButton.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameUI);
                    frame.revalidate();
                    frame.repaint();
                }

                if (getText().equals("4 PLAYERS")) {
                    GameUI gameUI = new GameUI(1000, 800);

                    // Reference to current frame
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MenuButton.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameUI);
                    frame.revalidate();
                    frame.repaint();
                }
            }
        });
    }
}