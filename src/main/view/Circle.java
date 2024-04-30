package main.view;

import javax.swing.*;
import java.awt.*;

class Circle {
    private int x, y, radius;
    private Image image;

    public Circle(int x, int y, int radius, String imagePath) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.image = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x - radius, y - radius, 2 * radius, 2 * radius, null);
    }
}

