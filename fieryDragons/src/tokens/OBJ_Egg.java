package tokens;
import javax.imageio.ImageIO;

public class OBJ_Egg extends DragonCards{
    public OBJ_Egg(){
        name = "egg";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/egg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
