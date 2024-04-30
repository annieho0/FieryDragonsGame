package main.view;

import main.buttons.*;
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

        DragonCard salamanderCard = new SalamanderCard(400, 300, 50, Color.GREEN, Color.BLACK);
        SalamanderCardButton salamanderButton = new SalamanderCardButton(salamanderCard);
        salamanderButton.setBounds(positions.get(0).x, positions.get(0).y, 50, 50);
        board.add(salamanderButton);

        DragonCard spiderCard = new SpiderCard(400, 300, 50, Color.GREEN, Color.BLACK);
        SpiderCardButton spiderButton = new SpiderCardButton(spiderCard);
        spiderButton.setBounds(positions.get(1).x, positions.get(1).y, 50, 50);
        board.add(spiderButton);

        DragonCard babyDragonCard = new BabyDragonCard(400, 300, 50, Color.GREEN, Color.BLACK);
        BabyDragonCardButton babyDragonButton = new BabyDragonCardButton(babyDragonCard);
        babyDragonButton.setBounds(positions.get(2).x, positions.get(2).y, 50, 50);
        board.add(babyDragonButton);

        DragonCard batCard = new BatCard(400, 300, 50, Color.GREEN, Color.BLACK);
        BatCardButton batButton = new BatCardButton(batCard);
        batButton.setBounds(positions.get(3).x, positions.get(3).y, 50, 50);
        board.add(batButton);

        DragonCard twoSalamanderCard = new TwoSalamanderCard(400, 300, 50, Color.GREEN, Color.BLACK);
        TwoSalamanderCardButton salamanderButton2 = new TwoSalamanderCardButton(twoSalamanderCard);
        salamanderButton2.setBounds(positions.get(4).x, positions.get(4).y, 50, 50);
        board.add(salamanderButton2);

        DragonCard threeSalamanderCard = new ThreeSalamanderCard(400, 300, 50, Color.GREEN, Color.BLACK);
        ThreeSalamanderCardButton threesalamanderButton = new ThreeSalamanderCardButton(threeSalamanderCard);
        threesalamanderButton.setBounds(positions.get(5).x, positions.get(5).y, 50, 50);
        board.add(threesalamanderButton);

        DragonCard twoSpiderCard = new TwoSpiderCard(400, 300, 50, Color.GREEN, Color.BLACK);
        TwoSpiderCardButton twospiderButton = new TwoSpiderCardButton(twoSpiderCard);
        twospiderButton.setBounds(positions.get(6).x, positions.get(6).y, 50, 50);
        board.add(twospiderButton);

        DragonCard threeSpiderCard = new ThreeSpiderCard(400, 300, 50, Color.GREEN, Color.BLACK);
        ThreeSpiderCardButton threespiderButton = new ThreeSpiderCardButton(threeSpiderCard);
        threespiderButton.setBounds(positions.get(7).x, positions.get(7).y, 50, 50);
        board.add(threespiderButton);

        DragonCard twoBatCard = new TwoBatCard(400, 300, 50, Color.GREEN, Color.BLACK);
        TwoBatCardButton twoBatButton = new TwoBatCardButton(twoBatCard);
        twoBatButton.setBounds(positions.get(8).x, positions.get(8).y, 50, 50);
        board.add(twoBatButton);

        DragonCard threeBatCard = new ThreeBatCard(400, 300, 50, Color.GREEN, Color.BLACK);
        ThreeBatCardButton threeBatButton = new ThreeBatCardButton(threeBatCard);
        threeBatButton.setBounds(positions.get(9).x, positions.get(9).y, 50, 50);
        board.add(threeBatButton);

        DragonCard twoBabyDragonCard = new TwoBabyDragonCard(400, 300, 50, Color.GREEN, Color.BLACK);
        TwoBabyDragonCardButton twoBabyDragonButton = new TwoBabyDragonCardButton(twoBabyDragonCard);
        twoBabyDragonButton.setBounds(positions.get(10).x, positions.get(10).y, 50, 50);
        board.add(twoBabyDragonButton);

        DragonCard threeBabyDragonCard = new ThreeBabyDragonCard(400, 300, 50, Color.GREEN, Color.BLACK);
        ThreeBabyDragonCardButton threeBabyDragonButton = new ThreeBabyDragonCardButton(threeBabyDragonCard);
        threeBabyDragonButton.setBounds(positions.get(11).x, positions.get(11).y, 50, 50);
        board.add(threeBabyDragonButton);

        DragonCard pirateCard = new PirateCard(400, 300, 50, Color.GREEN, Color.BLACK);
        PirateCardButton pirateButton = new PirateCardButton(pirateCard);
        pirateButton.setBounds(positions.get(12).x, positions.get(12).y, 50, 50);
        board.add(pirateButton);

        DragonCard pirateCard1 = new PirateCard(400, 300, 50, Color.GREEN, Color.BLACK);
        PirateCardButton pirateButton1 = new PirateCardButton(pirateCard1);
        pirateButton1.setBounds(positions.get(13).x, positions.get(13).y, 50, 50);
        board.add(pirateButton1);

        DragonCard twoPirateCard = new TwoPirateCard(400, 300, 50, Color.GREEN, Color.BLACK);
        TwoPirateCardButton twoPirateButton = new TwoPirateCardButton(twoPirateCard);
        twoPirateButton.setBounds(positions.get(14).x, positions.get(14).y, 50, 50);
        board.add(twoPirateButton);

        DragonCard twoPirateCard1 = new TwoPirateCard(400, 300, 50, Color.GREEN, Color.BLACK);
        TwoPirateCardButton twoPirateButton1 = new TwoPirateCardButton(twoPirateCard1);
        twoPirateButton1.setBounds(positions.get(15).x, positions.get(15).y, 50, 50);
        board.add(twoPirateButton1);






        board.setPreferredSize(new Dimension(width,height));
        board.setFocusable(false);

        add(board);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
