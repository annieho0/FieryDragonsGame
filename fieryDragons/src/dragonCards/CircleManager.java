package dragonCards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The CircleManager class manages the creation and initialization of circular cards on the screen.
 */
public class CircleManager {
    private ArrayList<String> availableImages;
    private Cards[] cards;

    /**
     * Constructs a CircleManager with the specified list of available images.
     *
     * @param availableImages The list of available images to be used for the back of the circular cards.
     */
    public CircleManager(ArrayList<String> availableImages) {
        this.availableImages = availableImages;
    }

    /**
     * Initializes circular cards on the screen.
     *
     * @param screenWidth  The width of the screen.
     * @param screenHeight The height of the screen.
     */
    public void initializeCircles(int screenWidth, int screenHeight) {
        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;

        // Calculate circle radius
        int radius = Math.min(screenWidth, screenHeight) / 5;

        // Initialize cards
        int numCircles = 16;
        int circleSize = 40;
        double angleStep = 2 * Math.PI / numCircles;
        cards = new Cards[numCircles];

        // Shuffle the list of available images
        Collections.shuffle(availableImages);

        for (int i = 0; i < numCircles; i++) {
            double angle = angleStep * i;
            int xOffset = 25;
            int circleX = (int) (centerX + radius * Math.cos(angle)) - (circleSize / 2) + xOffset;
            int yOffset = 25;
            int circleY = (int) (centerY + radius * Math.sin(angle)) - (circleSize / 2) - yOffset;
            cards[i] = new Cards(circleX, circleY, circleSize);
            // Set front image for each circle
            cards[i].setFrontImage("/objects/dragon.png");
            // Set back image for each circle from shuffled list
            String backImagePath = availableImages.get(i);
            cards[i].setBackImage(backImagePath, i);
        }
    }

    /**
     * Gets the array of circular cards.
     *
     * @return The array of circular cards.
     */
    public Cards[] getCards() {
        return cards;
    }
}
