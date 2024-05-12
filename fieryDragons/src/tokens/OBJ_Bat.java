package tokens;

import javax.imageio.ImageIO;

public class OBJ_Bat extends DragonCards{
    public OBJ_Bat(){
        this.setName("bat");
        this.setImagePath("/objects/bat.gif");
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/bat.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
