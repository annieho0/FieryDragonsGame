package circle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Circle {
    private int x;
    private int y;
    private int size;
    private BufferedImage image;
    private boolean clicked;

    public Circle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.clicked = false;
    }
    public void setImage(String imagePath) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
            // Handle the error gracefully, e.g., by setting a default image
        }
    }

    public void draw(Graphics2D g2d) {
        if (clicked && image != null) {
            g2d.drawImage(image, x, y, size, size, null);
        } else {
            g2d.setColor(Color.RED);
            g2d.fillRect(x, y, size, size);
        }
    }

    public boolean contains(int clickX, int clickY) {
        int centerX = x + size / 2;
        int centerY = y + size / 2;
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        return distance <= size / 2;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }


}
