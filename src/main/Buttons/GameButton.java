package main.Buttons;

import main.UserInterface.MenuUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButton extends JButton {

    public GameButton(String label) {
        super(label);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getText().equals("EXIT")) {
                    System.exit(0);
                }

                if (getText().equals("LOAD GAME")) {
                    MenuUI menuUI = new MenuUI(1000, 800);

                    // Reference to current frame
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(GameButton.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(menuUI);
                    frame.revalidate();
                    frame.repaint();
                }
            }
        });
    }
}
