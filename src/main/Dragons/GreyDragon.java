package main.Dragons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GreyDragon extends Dragon {
    Image greyDragonImg;
    String greyDragon = "src/images/GreyDragon.png";

    public GreyDragon(int dragonX, int dragonY, int dragonWidth, int dragonHeight) {
        super(dragonX, dragonY, dragonWidth, dragonHeight);

        try {
            greyDragonImg = ImageIO.read(new File(greyDragon));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        // drawing the dragon
        g2.drawImage(greyDragonImg, dragonX, dragonY, dragonWidth, dragonHeight, null);

    }
}





