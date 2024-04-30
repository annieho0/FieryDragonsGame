package main.buttons;

import main.buttons.CardButton;
import main.cards.DragonCard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SalamanderCardButton extends CardButton {

    public SalamanderCardButton(DragonCard card) {
        super(card);
    }

    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/salamander.png");
    }

    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
