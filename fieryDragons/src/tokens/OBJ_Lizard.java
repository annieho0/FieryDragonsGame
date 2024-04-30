package tokens;
import javax.imageio.ImageIO;

public class OBJ_Lizard extends DragonCards{
    public OBJ_Lizard(){
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/lizard.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
