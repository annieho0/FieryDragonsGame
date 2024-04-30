package main.cards;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

public abstract class DragonCard extends JComponent implements MouseListener {

    protected int x;
    protected int y;
    protected int radius;
    protected Color fillColor;
    protected Color borderColor;
    protected boolean isFlipped = false;

    public DragonCard(int x, int y, int radius, Color fillColor, Color borderColor) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        addMouseListener(this);
    }

    public abstract void draw(Graphics2D g2d);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw((Graphics2D) g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        repaint();
    }


}
