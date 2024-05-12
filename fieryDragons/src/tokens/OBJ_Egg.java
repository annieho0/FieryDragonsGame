package tokens;
import javax.imageio.ImageIO;

public class OBJ_Egg extends DragonCards{
    public OBJ_Egg(){
        this.setName("egg");
        this.setImagePath("/objects/egg.png");
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/egg.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
