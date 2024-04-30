package main.view;

import java.awt.*;

public class Cave {
    private int x;
    private int y;
    private int radius;
    private Color fillColor;
    private Color borderColor;

    public Cave(int x, int y, int radius, Color fillColor, Color borderColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public void draw(Graphics2D g2d) {
        //border
        int borderWidth = 5;
        g2d.setColor(borderColor);
        g2d.fillOval(x - radius - borderWidth, y - radius - borderWidth, 2 * (radius + borderWidth), 2 * (radius + borderWidth));

        //filled oval
        g2d.setColor(fillColor);
        g2d.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}
