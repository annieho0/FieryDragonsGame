package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a pirate card.
 * Extends the CardButton class and provides specific functionality for a button associated with a pirate card.
 */
public class PirateCardButton extends CardButton {

    /**
     * Constructs a new PirateCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public PirateCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the pirate card when flipped.
     *
     * @return The loaded image of the pirate card when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/pirate.png");
    }

    /**
     * Loads the image of the pirate card when not flipped.
     *
     * @return The loaded image of the pirate card when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
