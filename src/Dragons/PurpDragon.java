package Dragons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PurpDragon extends Dragon {
    Image purpDragonImg;
    String purpDragon = "PurpDragon2.png";

    public PurpDragon(int dragonX, int dragonY, int dragonWidth, int dragonHeight) {
        super(dragonX, dragonY, dragonWidth, dragonHeight);

        try {
            purpDragonImg = ImageIO.read(new File(purpDragon));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        // drawing the dragon
        g2.drawImage(purpDragonImg, dragonX, dragonY, dragonWidth, dragonHeight, null);

    }
}