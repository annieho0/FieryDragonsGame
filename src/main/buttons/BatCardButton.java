package main.buttons;

import main.cards.DragonCard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BatCardButton extends CardButton {

    public BatCardButton(DragonCard card) {
        super(card);
    }

    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/bat.png");
    }

    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
