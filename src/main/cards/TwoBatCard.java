package main.cards;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Represents a card that depicts two bats.
 * Extends the DragonCard class and provides specific functionality for a card with two bats.
 */
public class TwoBatCard extends DragonCard {

    /**
     * Constructs a new TwoBatCard with the specified coordinates.
     *
     * @param x The x-coordinate of the card.
     * @param y The y-coordinate of the card.
     */
    public TwoBatCard(int x, int y) {
        super(x, y);
        setFocusable(true);
    }

    /**
     * Draws the card with two bats on the graphics context.
     *
     * @param g2d The graphics context on which to draw the card.
     */
    @Override
    public void draw(Graphics2D g2d) {
        // Custom drawing logic for the card with two bats
    }

    /**
     * Handles the mouseClicked event for the card with two bats.
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
