package player;

import dragonCards.Cards;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The Player class represents a player entity in the game.
 */
public abstract class Player extends Entity {
    protected GamePanel gp;
    protected BufferedImage dragonImage;
    protected PlayerTurn playerTurn;

    /**
     * Constructs a Player object.
     *
     * @param gp         The GamePanel associated with the game.
     * @param imagePath  The path of the player's dragon image.
     * @param startX     The initial x-coordinate of the player.
     * @param startY     The initial y-coordinate of the player.
     * @param playerTurn The player turn object associated with the player.
     */
    public Player(GamePanel gp, String imagePath, int startX, int startY, PlayerTurn playerTurn) {
        this.gp = gp;
        this.playerTurn = playerTurn;
        setDefaultValues(startX, startY);
        getDragonImage(imagePath);
    }

    /**
     * Abstract method to update the player's state.
     */
    public abstract void update();

    /**
     * Draws the player on the graphics context.
     *
     * @param g2 The graphics context on which to draw the player.
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(dragonImage, x, y, gp.tileSize, gp.tileSize, null);
    }

    /**
     * Loads the player's dragon image from the specified path.
     *
     * @param imagePath The path of the player's dragon image.
     */
    protected void getDragonImage(String imagePath) {
        try {
            dragonImage = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the player's turn.
     *
     * @return The player's turn.
     */
    public PlayerTurn getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Sets the player's turn.
     *
     * @param playerTurn The player's turn.
     */
    public void setPlayerTurn(PlayerTurn playerTurn) {
        this.playerTurn = playerTurn;
    }

    /**
     * Switches the player's turn between PINK and PURPLE.
     */
    public void switchPlayerTurn() {
        playerTurn = (playerTurn == PlayerTurn.PINK) ? PlayerTurn.PURPLE : PlayerTurn.PINK;
    }

    /**
     * Checks if the player contains the specified coordinates.
     *
     * @param mouseX The x-coordinate to check.
     * @param mouseY The y-coordinate to check.
     * @return True if the player contains the coordinates, false otherwise.
     */
    public boolean contains(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + gp.tileSize &&
                mouseY >= y && mouseY <= y + gp.tileSize;
    }

    /**
     * Sets the current position of the player.
     *
     * @param positionX The x-coordinate of the position.
     * @param positionY The y-coordinate of the position.
     */
    public void setCurrentPosition(int positionX, int positionY) {
        x = positionX * gp.tileSize;
        y = positionY * gp.tileSize;
    }

    /**
     * Gets the x-coordinate of the player.
     *
     * @return The x-coordinate of the player.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the player.
     *
     * @return The y-coordinate of the player.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the default values of the player's position.
     *
     * @param startX The initial x-coordinate of the player.
     * @param startY The initial y-coordinate of the player.
     */
    protected void setDefaultValues(int startX, int startY) {
        x = startX * gp.tileSize;
        y = startY * gp.tileSize;
    }
}
