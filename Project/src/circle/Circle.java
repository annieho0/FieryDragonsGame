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
    private String imagePath;

    public Circle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.clicked = false;
    }

    public String getImage() {
        return imagePath;
    }

    public void setImage(String imagePath) {
        this.imagePath = imagePath;
        if (imagePath != null && !imagePath.isEmpty()) {
            try {
                this.image = ImageIO.read(new File(imagePath)); // Load the image from file path
            } catch (IOException e) {
                this.image = null;
                System.err.println("Error loading image: " + e.getMessage());
                // Handle the error gracefully, e.g., by setting a default image or logging the error
            }
        } else {
            this.image = null; // Set the image to null if imagePath is null or empty
        }
    }

    public void draw(Graphics2D g2d) {
        if (clicked && image != null) {
            g2d.drawImage(image, x, y, size, size, null);
        } else {
            g2d.setColor(Color.GRAY);
            g2d.fillOval(x, y, size, size);
        }
    }

    public boolean contains(int clickX, int clickY) {
        int centerX = x + size / 2;
        int centerY = y + size / 2;
        double distance = Math.sqrt(Math.pow(clickX - centerX, 2) + Math.pow(clickY - centerY, 2));
        return distance <= size / 2;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    private int lastImageIndex = -1; // Initialize to -1 to indicate no image

    // Other existing code...

    public int getLastImageIndex() {
        return lastImageIndex;
    }

    public void setLastImageIndex(int lastImageIndex) {
        this.lastImageIndex = lastImageIndex;
    }
}
