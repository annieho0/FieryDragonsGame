package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a card with two pirates.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing two pirates.
 */
public class TwoPirateCardButton extends CardButton {

    /**
     * Constructs a new TwoPirateCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public TwoPirateCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with two pirates when flipped.
     *
     * @return The loaded image of the card with two pirates when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/twopirates.png");
    }

    /**
     * Loads the image of the card with two pirates when not flipped.
     *
     * @return The loaded image of the card with two pirates when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
