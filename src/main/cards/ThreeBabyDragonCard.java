package main.cards;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Represents a card that depicts three baby dragons.
 * Extends the DragonCard class and provides specific functionality for a card with three baby dragons.
 */
public class ThreeBabyDragonCard extends DragonCard {

    /**
     * Constructs a new ThreeBabyDragonCard with the specified coordinates.
     *
     * @param x The x-coordinate of the card.
     * @param y The y-coordinate of the card.
     */
    public ThreeBabyDragonCard(int x, int y) {
        super(x, y);
        setFocusable(true);
    }

    /**
     * Draws the card with three baby dragons on the graphics context.
     *
     * @param g2d The graphics context on which to draw the card.
     */
    @Override
    public void draw(Graphics2D g2d) {
        // Custom drawing logic for the card with three baby dragons
    }

    /**
     * Handles the mouseClicked event for the card with three baby dragons.
     * Flips the card when clicked.
     *
     * @param e The MouseEvent representing the mouse click event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        isFlipped = !isFlipped;
        repaint();
    }

    // The following methods are overridden from the MouseListener interface but are not used in this class,
    // so they are left empty.

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
