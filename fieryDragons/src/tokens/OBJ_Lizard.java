package tokens;
import javax.imageio.ImageIO;

public class OBJ_Lizard extends DragonCards{
    public OBJ_Lizard(){
        this.setName("lizard");
        this.setImagePath("/objects/lizard.png");
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/lizard.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
