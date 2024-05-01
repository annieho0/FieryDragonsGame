package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a card with two spiders.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing two spiders.
 */
public class TwoSpiderCardButton extends CardButton {

    /**
     * Constructs a new TwoSpiderCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public TwoSpiderCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with two spiders when flipped.
     *
     * @return The loaded image of the card with two spiders when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/twospiders.png");
    }

    /**
     * Loads the image of the card with two spiders when not flipped.
     *
     * @return The loaded image of the card with two spiders when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
