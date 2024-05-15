package tokens;

import main.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The DragonCards class represents an abstract class for dragon cards in the game.
 */
public abstract class DragonCards {

    /** The image of the dragon card. */
    public BufferedImage image;

    /** The name of the dragon card. */
    public String name;

    /** The x-coordinate of the dragon card's position. */
    public int x;

    /** The y-coordinate of the dragon card's position. */
    public int y;

    /** The file path of the dragon card's image. */
    private String imagePath;

    /**
     * Sets the file path of the dragon card's image.
     *
     * @param imagePath The file path of the dragon card's image.
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Gets the file path of the dragon card's image.
     *
     * @return The file path of the dragon card's image.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets the name of the dragon card.
     *
     * @param name The name of the dragon card.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets the name of the dragon card.
     *
     * @return The name of the dragon card.
     */
    public String getName() {
        return name;
    }

    /**
     * Draws the dragon card on the game panel.
     *
     * @param g2 The Graphics2D object used for drawing.
     * @param gp The GamePanel object.
     */
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
