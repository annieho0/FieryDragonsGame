package circle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Circle {
    private int x, y, size;
    private String frontImagePath;
    private String backImagePath;
    private Image frontImage;
    private Image backImage;
    private boolean flipped;
    private int backImageIndex;

    public Circle(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.flipped = false;
        this.backImageIndex = -1; // Initialize with an invalid index
    }

    public void setFrontImage(String imagePath) {
        this.frontImagePath = imagePath;
        try {
            this.frontImage = ImageIO.read(new File(frontImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBackImage(String imagePath, int index) {
        this.backImagePath = imagePath;
        this.backImageIndex = index;
        try {
            if (this.backImage == null) { // Load the back image only if it hasn't been loaded before
                this.backImage = ImageIO.read(new File(backImagePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flip() {
        flipped = !flipped;
    }

    public boolean contains(int mx, int my) {
        return mx >= x && mx <= x + size && my >= y && my <= y + size;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void draw(Graphics2D g) {
        if (flipped) {
            g.drawImage(backImage, x, y, size, size, null);
        } else {
            g.drawImage(frontImage, x, y, size, size, null);
        }
    }
}
