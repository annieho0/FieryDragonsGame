package main.cards;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ThreeSalamanderCard extends DragonCard {

    public ThreeSalamanderCard(int x, int y, int radius, Color fillColor, Color borderColor) {
        super(x, y, radius, fillColor, borderColor);
        setFocusable(true);
    }

    @Override
    public void draw(Graphics2D g2d) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isFlipped = !isFlipped;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
