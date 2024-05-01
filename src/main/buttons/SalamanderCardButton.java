package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a salamander card.
 * Extends the CardButton class and provides specific functionality for a button associated with a salamander card.
 */
public class SalamanderCardButton extends CardButton {

    /**
     * Constructs a new SalamanderCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public SalamanderCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the salamander card when flipped.
     *
     * @return The loaded image of the salamander card when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/salamander.png");
    }

    /**
     * Loads the image of the salamander card when not flipped.
     *
     * @return The loaded image of the salamander card when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
