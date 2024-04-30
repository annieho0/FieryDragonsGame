package main.cards;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SalamanderCard extends DragonCard {

    public SalamanderCard(int x, int y) {
        super(x, y);
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
