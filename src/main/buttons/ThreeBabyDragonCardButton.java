package main.buttons;

import main.buttons.CardButton;
import main.cards.DragonCard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ThreeBabyDragonCardButton extends CardButton {

    public ThreeBabyDragonCardButton(DragonCard card) {
        super(card);
    }

    @Override
    protected BufferedImage loadImageFlipped() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("/images/threebabydragons.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    @Override
    protected BufferedImage loadImageNotFlipped() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("/images/volcano.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;

    }
}
