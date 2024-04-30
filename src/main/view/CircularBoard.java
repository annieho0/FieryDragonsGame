package main.view;

import main.cards.DragonCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CircularBoard extends JPanel {

    private int diameter;
    private int holeDiameter;


    public CircularBoard(int diameter, int holeDiameter) {
        this.diameter = diameter;
        this.holeDiameter = holeDiameter;
        setPreferredSize(new Dimension(diameter, diameter));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        int outerX = (getWidth() - diameter) / 2;
        int outerY = (getHeight() - diameter) / 2;
        int innerX = (getWidth() - holeDiameter) / 2;
        int innerY = (getHeight() - holeDiameter) / 2;


        g2d.setColor(Color.lightGray);
        g2d.fillOval(outerX, outerY, diameter, diameter);


        g2d.setColor(getBackground());
        g2d.fillOval(innerX, innerY, holeDiameter, holeDiameter);


        double startAngle = Math.PI / 0.3691;
        double angleIncrement = 2 * Math.PI / 24;
        for (int i = 0; i < 24; i++) {
            double angle = startAngle + i * angleIncrement;
            int startX = (int) (getWidth() / 2 + Math.cos(angle) * (diameter / 2));
            int startY = (int) (getHeight() / 2 + Math.sin(angle) * (diameter / 2));
            int endX = (int) (getWidth() / 2 + Math.cos(angle) * (holeDiameter / 2));
            int endY = (int) (getHeight() / 2 + Math.sin(angle) * (holeDiameter / 2));
            g2d.drawLine(startX, startY, endX, endY);
        }


        int caveOffset = (int) (25 / 1.5);
        Cave northCave = new Cave(getWidth() / 2, outerY - caveOffset, 27, Color.lightGray, Color.pink);
        Cave southCave = new Cave(getWidth() / 2, outerY + diameter + caveOffset, 27, Color.lightGray, Color.yellow);
        Cave eastCave = new Cave(outerX + diameter + caveOffset, getHeight() / 2, 27, Color.lightGray, Color.blue);
        Cave westCave = new Cave(outerX - caveOffset, getHeight() / 2, 27, Color.lightGray, Color.orange);


        northCave.draw(g2d);
        southCave.draw(g2d);
        eastCave.draw(g2d);
        westCave.draw(g2d);

    }

}
