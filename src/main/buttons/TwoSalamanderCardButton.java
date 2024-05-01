package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a card with two salamanders.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing two salamanders.
 */
public class TwoSalamanderCardButton extends CardButton {

    /**
     * Constructs a new TwoSalamanderCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public TwoSalamanderCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with two salamanders when flipped.
     *
     * @return The loaded image of the card with two salamanders when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/twosalamanders.png");
    }

    /**
     * Loads the image of the card with two salamanders when not flipped.
     *
     * @return The loaded image of the card with two salamanders when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
