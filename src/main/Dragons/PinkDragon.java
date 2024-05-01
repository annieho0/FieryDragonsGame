package main.Dragons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PinkDragon extends Dragon {
    Image pinkDragonImg;
    String pinkDragon = "src/images/PinkDragon.png";

    public PinkDragon(int dragonX, int dragonY, int dragonWidth, int dragonHeight) {
        super(dragonX, dragonY, dragonWidth, dragonHeight);

        try {
            pinkDragonImg = ImageIO.read(new File(pinkDragon));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        // drawing the dragon
        g2.drawImage(pinkDragonImg, dragonX, dragonY, dragonWidth, dragonHeight, null);

    }
}