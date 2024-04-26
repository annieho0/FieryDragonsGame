package src.main;

import javax.swing.*;
import java.awt.*;

public class CircularBoard extends JPanel {

    private int diameter;
    private int holeDiameter; // Diameter of the hole in the center

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

        // Calculate the position to center the circles
        int outerX = (getWidth() - diameter) / 2;
        int outerY = (getHeight() - diameter) / 2;
        int innerX = (getWidth() - holeDiameter) / 2;
        int innerY = (getHeight() - holeDiameter) / 2;

        // Draw the outer circle (board)
        g2d.setColor(Color.BLACK);
        g2d.fillOval(outerX, outerY, diameter, diameter);

        // Draw the inner circle (hole)
        g2d.setColor(getBackground()); // Use the background color to "erase" the inner circle
        g2d.fillOval(innerX, innerY, holeDiameter, holeDiameter);

        // Draw lines to split the donut circle into 24 equal pieces
        double angleIncrement = 2 * Math.PI / 24;
        for (int i = 0; i < 24; i++) {
            double angle = i * angleIncrement;
            int startX = (int) (getWidth() / 2 + Math.cos(angle) * (diameter / 2));
            int startY = (int) (getHeight() / 2 + Math.sin(angle) * (diameter / 2));
            int endX = (int) (getWidth() / 2 + Math.cos(angle) * (holeDiameter / 2));
            int endY = (int) (getHeight() / 2 + Math.sin(angle) * (holeDiameter / 2));
            g2d.drawLine(startX, startY, endX, endY);
        }
    }


}
