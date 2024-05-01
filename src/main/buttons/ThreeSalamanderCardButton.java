package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a card with three salamanders.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing three salamanders.
 */
public class ThreeSalamanderCardButton extends CardButton {

    /**
     * Constructs a new ThreeSalamanderCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public ThreeSalamanderCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with three salamanders when flipped.
     *
     * @return The loaded image of the card with three salamanders when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/threesalamanders.png");
    }

    /**
     * Loads the image of the card with three salamanders when not flipped.
     *
     * @return The loaded image of the card with three salamanders when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
