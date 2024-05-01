package main.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * Represents a cave in the game view.
 * The cave is defined by its position, radius, image, and border color.
 */
public class Cave {
    private int x;              // X-coordinate of the center of the cave
    private int y;              // Y-coordinate of the center of the cave
    private int radius;         // Radius of the cave
    private Image image;        // Image representing the cave
    private Color borderColor;  // Color of the cave's border

    /**
     * Constructs a new Cave object with the specified parameters.
     *
     * @param x           The X-coordinate of the center of the cave.
     * @param y           The Y-coordinate of the center of the cave.
     * @param radius      The radius of the cave.
     * @param imagePath   The path to the image file representing the cave.
     * @param borderColor The color of the cave's border.
     */
    public Cave(int x, int y, int radius, String imagePath, Color borderColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.borderColor = borderColor;
        try {
            Image originalImage = ImageIO.read(getClass().getResource(imagePath));
            int diameter = 2 * radius;
            this.image = originalImage.getScaledInstance(diameter, diameter, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Draws the cave on the specified Graphics2D object.
     *
     * @param g2d The Graphics2D object on which to draw the cave.
     */
    public void draw(Graphics2D g2d) {
        // Draw the border of the cave
        g2d.setColor(borderColor);
        g2d.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // Draw the filled cave
        if (image != null) {
            int imageX = x - radius;
            int imageY = y - radius;
            g2d.drawImage(image, imageX, imageY, null);
        }
    }
}
