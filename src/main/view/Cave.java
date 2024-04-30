package main.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Cave {
    private int x;
    private int y;
    private int radius;
    private Image image;
    private Color borderColor;

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

    public void draw(Graphics2D g2d) {
        //border
        int borderWidth = 5;
        g2d.setColor(borderColor);
        g2d.fillOval(x - radius - borderWidth, y - radius - borderWidth, 2 * (radius + borderWidth), 2 * (radius + borderWidth));

        //filled oval
        if (image != null) {
            int imageX = x - radius;
            int imageY = y - radius;
            g2d.drawImage(image, imageX, imageY, null);
        }
    }
}
