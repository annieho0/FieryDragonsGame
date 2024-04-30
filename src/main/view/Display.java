package main.view;

import main.buttons.BabyDragonCardButton;
import main.buttons.BatCardButton;
import main.buttons.SalamanderCardButton;
import main.buttons.SpiderCardButton;
import main.cards.*;
import main.view.CircularBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Display extends JFrame {

    private CircularBoard board;

    public Display (int width, int height) {
        setTitle("Fiery Dragon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        board = new CircularBoard(500, 380);
        board.setLayout(null);

        List<Point> positions = new ArrayList<>(Arrays.asList(
                new Point(340, 130),
                new Point(340, 205),
                new Point(340, 280),
                new Point(340, 355),
                new Point(420, 130),
                new Point(420, 205),
                new Point(420, 280),
                new Point(420, 355),
                new Point(500, 205),
                new Point(500, 280),
                new Point(500, 355),
                new Point(260, 205),
                new Point(260, 280),
                new Point(260, 355),
                new Point(340, 430),
                new Point(420, 430)
        ));

        Collections.shuffle(positions);

        for (int i = 0; i < 4; i++) {
            DragonCard salamanderCard = new SalamanderCard(400, 300, 50, Color.GREEN, Color.BLACK);
            SalamanderCardButton salamanderButton = new SalamanderCardButton(salamanderCard);
            salamanderButton.setBounds(positions.get(i).x, positions.get(i).y, 50, 50);
            board.add(salamanderButton);

            DragonCard spiderCard = new SpiderCard(400, 300, 50, Color.GREEN, Color.BLACK);
            SpiderCardButton spiderButton = new SpiderCardButton(spiderCard);
            spiderButton.setBounds(positions.get(i+4).x, positions.get(i+4).y, 50, 50);
            board.add(spiderButton);

            DragonCard babyDragonCard = new BabyDragonCard(400, 300, 50, Color.GREEN, Color.BLACK);
            BabyDragonCardButton babyDragonButton = new BabyDragonCardButton(babyDragonCard);
            babyDragonButton.setBounds(positions.get(i+8).x, positions.get(i+8).y, 50, 50);
            board.add(babyDragonButton);

            DragonCard batCard = new BatCard(400, 300, 50, Color.GREEN, Color.BLACK);
            BatCardButton batButton = new BatCardButton(batCard);
            batButton.setBounds(positions.get(i+12).x, positions.get(i+12).y, 50, 50);
            board.add(batButton);
        }

        board.setPreferredSize(new Dimension(width,height));
        board.setFocusable(false);

        add(board);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
