package tokens;

import javax.imageio.ImageIO;

public class OBJ_Bat extends DragonCards{
    public OBJ_Bat(){
        name = "key";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/bat.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
