package src.main;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {

    private CircularBoard board;

    public Display (int width, int height) {
        setTitle("Fiery Dragon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        board = new CircularBoard(400, 280);
        board.setPreferredSize(new Dimension(width,height));
        board.setFocusable(false);
        add(board);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
