package tokens;

import javax.imageio.ImageIO;

/**
 * The OBJ_Egg class represents a specific type of dragon card, namely an egg.
 */
public class OBJ_Egg extends DragonCards {

    /**
     * Constructs a new egg dragon card.
     */
    public OBJ_Egg() {
        this.setName("egg");
        this.setImagePath("/objects/egg.png");
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/egg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
