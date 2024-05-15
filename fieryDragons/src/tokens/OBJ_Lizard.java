package tokens;

import javax.imageio.ImageIO;

/**
 * The OBJ_Lizard class represents a specific type of dragon card, namely a lizard.
 */
public class OBJ_Lizard extends DragonCards {

    /**
     * Constructs a new lizard dragon card.
     */
    public OBJ_Lizard() {
        this.setName("lizard");
        this.setImagePath("/objects/lizard.png");
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/lizard.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
