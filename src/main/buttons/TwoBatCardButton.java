package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a card with two bats.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing two bats.
 */
public class TwoBatCardButton extends CardButton {

    /**
     * Constructs a new TwoBatCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public TwoBatCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with two bats when flipped.
     *
     * @return The loaded image of the card with two bats when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/twobats.png");
    }

    /**
     * Loads the image of the card with two bats when not flipped.
     *
     * @return The loaded image of the card with two bats when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
