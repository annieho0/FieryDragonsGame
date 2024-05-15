package tokens;

import javax.imageio.ImageIO;

/**
 * The OBJ_Bat class represents a specific type of dragon card, namely a bat.
 */
public class OBJ_Bat extends DragonCards {

    /**
     * Constructs a new bat dragon card.
     */
    public OBJ_Bat() {
        this.setName("bat");
        this.setImagePath("/objects/bat.gif");
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/bat.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
