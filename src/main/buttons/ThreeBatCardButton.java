package main.buttons;

import main.cards.DragonCard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Represents a button for a card with three bats.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing three bats.
 */
public class ThreeBatCardButton extends CardButton {

    /**
     * Constructs a new ThreeBatCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public ThreeBatCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with three bats when flipped.
     *
     * @return The loaded image of the card with three bats when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/threebats.png");
    }

    /**
     * Loads the image of the card with three bats when not flipped.
     *
     * @return The loaded image of the card with three bats when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
