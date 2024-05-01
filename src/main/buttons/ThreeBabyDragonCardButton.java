package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a card with three baby dragons.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing three baby dragons.
 */
public class ThreeBabyDragonCardButton extends CardButton {

    /**
     * Constructs a new ThreeBabyDragonCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public ThreeBabyDragonCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with three baby dragons when flipped.
     *
     * @return The loaded image of the card with three baby dragons when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/threebabydragons.png");
    }

    /**
     * Loads the image of the card with three baby dragons when not flipped.
     *
     * @return The loaded image of the card with three baby dragons when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
