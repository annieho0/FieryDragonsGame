package Dragons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BlueDragon extends Dragon {
    Image blueDragonImg;
    String blueDragon = "BlueDragon2.png";

    public BlueDragon(int dragonX, int dragonY, int dragonWidth, int dragonHeight) {
        super(dragonX, dragonY, dragonWidth, dragonHeight);

        try {
            blueDragonImg = ImageIO.read(new File(blueDragon));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        // drawing the dragon
        g2.drawImage(blueDragonImg, dragonX, dragonY, dragonWidth, dragonHeight, null);

    }
}