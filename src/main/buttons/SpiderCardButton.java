package main.buttons;

import main.cards.DragonCard;
import java.awt.image.BufferedImage;

/**
 * Represents a button for a spider card.
 * Extends the CardButton class and provides specific functionality for a button associated with a spider card.
 */
public class SpiderCardButton extends CardButton {

    /**
     * Constructs a new SpiderCardButton with the specified dragon card.
     *
     * @param card The dragon card associated with the button.
     */
    public SpiderCardButton(DragonCard card) {
        super(card);
    }

    /**
     * Loads the image of the spider card when flipped.
     *
     * @return The loaded image of the spider card when flipped.
     */
    @Override
    protected BufferedImage loadImageFlipped() {
        return loadImageFlipped("/images/spider.png");
    }

    /**
     * Loads the image of the spider card when not flipped.
     *
     * @return The loaded image of the spider card when not flipped.
     */
    @Override
    protected BufferedImage loadImageNotFlipped() {
        return loadImageNotFlipped("/images/volcano.png");
    }
}
