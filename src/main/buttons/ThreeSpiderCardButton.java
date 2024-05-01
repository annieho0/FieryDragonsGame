package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a card with three spiders.
 * Extends the CardButton class and provides specific functionality for a button associated with a card containing three spiders.
 */
public class ThreeSpiderCardButton extends CardButton {

    /**
     * Constructs a new ThreeSpiderCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public ThreeSpiderCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the card with three spiders when flipped.
     *
     * @return The loaded image of the card with three spiders when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/threespiders.png");
    }

    /**
     * Loads the image of the card with three spiders when not flipped.
     *
     * @return The loaded image of the card with three spiders when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
