package boardCards;

import java.util.ArrayList;
import java.util.List;

/**
 * The ImageLoader class is responsible for loading the paths of images used in the game.
 */
public class ImageLoader {
    /**
     * Loads the paths of images used in the game.
     *
     * @return A list of strings representing the paths of available images.
     */
    public static List<String> loadImages() {
        List<String> availableImages = new ArrayList<>();

        // Add paths of available images
        availableImages.add("/objects/bat.gif");
        availableImages.add("/objects/bat_2.png");
        availableImages.add("/objects/bat_3.png");
        availableImages.add("/objects/spider.png");
        availableImages.add("/objects/spider_2.png");
        availableImages.add("/objects/spider_3.png");
        availableImages.add("/objects/egg.png");
        availableImages.add("/objects/egg_2.png");
        availableImages.add("/objects/egg_3.png");
        availableImages.add("/objects/lizard.png");
        availableImages.add("/objects/lizard_2.png");
        availableImages.add("/objects/lizard_3.png");
        availableImages.add("/objects/skull.png");
        availableImages.add("/objects/skull_2.png");
        availableImages.add("/objects/skull.png");
        availableImages.add("/objects/skull_2.png");

        return availableImages;
    }
}
