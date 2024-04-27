import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton {

    public MyButton(String label) {
        super(label);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getText().equals("EXIT")) {
                    System.exit(0);
                }

                if (getText().equals("LOAD GAME")) {
                    MenuUI menuUI = new MenuUI();

                    // Reference to current frame
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MyButton.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(menuUI);
                    frame.revalidate();
                    frame.repaint();
                }

                if (getText().equals("BACK")) {
                    GameUI gameUI = new GameUI();

                    // Reference to current frame
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MyButton.this);
                    frame.getContentPane().removeAll();
                    frame.getContentPane().add(gameUI);
                    gameUI.PictureAnimation();
                    frame.revalidate();
                    frame.repaint();
                }

            }
        });
    }
}
