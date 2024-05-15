package tokens;

import javax.imageio.ImageIO;

/**
 * The OBJ_Spider class represents a specific type of dragon card, namely a spider.
 */
public class OBJ_Spider extends DragonCards {

    /**
     * Constructs a new spider dragon card.
     */
    public OBJ_Spider() {
        this.setName("spider");
        this.setImagePath("/objects/spider.png");
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/spider.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
