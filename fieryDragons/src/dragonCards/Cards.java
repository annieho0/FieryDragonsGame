package dragonCards;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

/**
 * The Cards class represents a playing card with a front and back image.
 */
public class Cards {
    private int x, y, size;
    private String frontImagePath;
    private String backImagePath;
    private Image frontImage;
    private Image backImage;
    private boolean flipped;
    private int backImageIndex;

    /**
     * Constructs a Cards object with the specified position and size.
     *
     * @param x    The x-coordinate of the card.
     * @param y    The y-coordinate of the card.
     * @param size The size (width and height) of the card.
     */
    public Cards(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.flipped = false;
        this.backImageIndex = -1; // Initialize with an invalid index
    }

    /**
     * Sets the front image of the card.
     *
     * @param imagePath The path of the front image file.
     */
    public void setFrontImage(String imagePath) {
        this.frontImagePath = imagePath;
        try {
            this.frontImage = ImageIO.read(getClass().getResourceAsStream(frontImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the path of the front image of the card.
     *
     * @return The path of the front image.
     */
    public String getFrontImage() {
        return frontImagePath;
    }

    /**
     * Sets the back image of the card.
     *
     * @param imagePath The path of the back image file.
     * @param index     The index of the back image.
     */
    public void setBackImage(String imagePath, int index) {
        this.backImagePath = imagePath;
        this.backImageIndex = index;
        try {
            if (this.backImage == null) { // Load the back image only if it hasn't been loaded before
                this.backImage = ImageIO.read(getClass().getResourceAsStream(backImagePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the index of the back image of the card.
     *
     * @return The index of the back image.
     */
    public int getBackImageIndex() {
        return backImageIndex;
    }

    /**
     * Gets the path of the back image of the card.
     *
     * @return The path of the back image.
     */
    public String getBackImage() {
        return backImagePath;
    }

    /**
     * Flips the card, changing its state from front-facing to back-facing or vice versa.
     */
    public void flip() {
        flipped = !flipped;
    }

    /**
     * Checks if the given coordinates are within the boundaries of the card.
     *
     * @param mx The x-coordinate to check.
     * @param my The y-coordinate to check.
     * @return True if the coordinates are within the card boundaries, false otherwise.
     */
    public boolean contains(int mx, int my) {
        return mx >= x && mx <= x + size && my >= y && my <= y + size;
    }

    /**
     * Checks if the card is flipped (back-facing).
     *
     * @return True if the card is flipped, false otherwise.
     */
    public boolean isFlipped() {
        return flipped;
    }

    /**
     * Draws the card on the graphics context.
     *
     * @param g The graphics context on which to draw the card.
     */
    public void draw(Graphics2D g) {
        if (flipped) {
            g.drawImage(backImage, x, y, size, size, null);
        } else {
            g.drawImage(frontImage, x, y, size, size, null);
        }
    }
}
