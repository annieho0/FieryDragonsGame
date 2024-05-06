package tokens;

import javax.imageio.ImageIO;

public class OBJ_Spider extends DragonCards{
    public OBJ_Spider(){
        name = "spider";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/spider.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
