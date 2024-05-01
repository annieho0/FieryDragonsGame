package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a bat card.
 * Extends the CardButton class and provides specific functionality for a button associated with a bat card.
 */
public class BatCardButton extends CardButton {

    /**
     * Constructs a new BatCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public BatCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the bat card when flipped.
     *
     * @return The loaded image of the bat card when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/bat.png");
    }

    /**
     * Loads the image of the bat card when not flipped.
     *
     * @return The loaded image of the bat card when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
