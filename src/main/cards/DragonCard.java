package main.cards;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 * Represents an abstract class for a dragon-themed card.
 * Provides common functionality for all dragon cards.
 */
public abstract class DragonCard extends JComponent implements MouseListener {

    /** The x-coordinate of the card. */
    protected int x;

    /** The y-coordinate of the card. */
    protected int y;

    /** Indicates whether the card is flipped. */
    protected boolean isFlipped = false;

    /**
     * Constructs a new DragonCard with the specified coordinates.
     *
     * @param x The x-coordinate of the card.
     * @param y The y-coordinate of the card.
     */
    public DragonCard(int x, int y) {
        this.x = x;
        this.y = y;
        addMouseListener(this);
    }

    /**
     * Draws the dragon card on the graphics context.
     *
     * @param g2d The graphics context on which to draw the card.
     */
    public abstract void draw(Graphics2D g2d);

    /**
     * Overrides the paintComponent method to draw the card.
     *
     * @param g The graphics context on which to paint the component.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw((Graphics2D) g);
    }

    /**
     * Handles the mouseClicked event for the dragon card.
     *
     * @param e The MouseEvent representing the mouse click event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
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
