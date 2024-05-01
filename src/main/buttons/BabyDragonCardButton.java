package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a baby dragon card.
 * Extends the CardButton class and provides specific functionality for a button associated with a baby dragon card.
 */
public class BabyDragonCardButton extends CardButton {

    /**
     * Constructs a new BabyDragonCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public BabyDragonCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the baby dragon card when flipped.
     *
     * @return The loaded image of the baby dragon card when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/babydragon.png");
    }

    /**
     * Loads the image of the baby dragon card when not flipped.
     *
     * @return The loaded image of the baby dragon card when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
