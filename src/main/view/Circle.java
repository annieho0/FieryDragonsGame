package main.view;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a circle in the game view.
 * The circle is defined by its position, radius, and image.
 */
class Circle {
    private int x;      // X-coordinate of the center of the circle
    private int y;      // Y-coordinate of the center of the circle
    private int radius; // Radius of the circle
    private Image image;// Image representing the circle

    /**
     * Constructs a new Circle object with the specified parameters.
     *
     * @param x         The X-coordinate of the center of the circle.
     * @param y         The Y-coordinate of the center of the circle.
     * @param radius    The radius of the circle.
     * @param imagePath The path to the image file representing the circle.
     */
    public Circle(int x, int y, int radius, String imagePath) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.image = new ImageIcon(getClass().getResource(imagePath)).getImage();
    }

    /**
     * Draws the circle on the specified Graphics2D object.
     *
     * @param g2d The Graphics2D object on which to draw the circle.
     */
    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x - radius, y - radius, 2 * radius, 2 * radius, null);
    }
}
