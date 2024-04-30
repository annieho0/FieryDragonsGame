package main.buttons;

import main.cards.DragonCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class CardButton extends JButton {
    protected DragonCard card;
    protected boolean isPressed = false;
    private BufferedImage image;

    private BufferedImage image2;

    protected BufferedImage loadImageFlipped(String imagePath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    protected BufferedImage loadImageNotFlipped(String imagePath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public CardButton(DragonCard card) {
        this.card = card;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPressed = !isPressed;
                card.mouseClicked(null);
            }
        });

        image = loadImageFlipped();
        image2 = loadImageNotFlipped();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage currentImage = isPressed ? image : image2;
        Image scaledImage = currentImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        g.drawImage(scaledImage, 0, 0, this);
    }



    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    protected abstract BufferedImage loadImageFlipped();
    protected abstract BufferedImage loadImageNotFlipped();
}
