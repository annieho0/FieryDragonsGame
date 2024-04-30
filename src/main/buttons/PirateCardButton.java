package main.buttons;

import main.cards.DragonCard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PirateCardButton extends CardButton {

    public PirateCardButton(DragonCard card) {
        super(card);
    }

    @Override
    protected BufferedImage loadImageFlipped() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("/images/pirate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    @Override
    protected BufferedImage loadImageNotFlipped() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("/images/fire.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;

    }
}
