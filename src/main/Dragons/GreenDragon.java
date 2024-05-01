package main.Dragons;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GreenDragon extends Dragon {
    Image greenDragonImg;
    String greenDragon = "src/images/GreenDragon.png";

    public GreenDragon(int dragonX, int dragonY, int dragonWidth, int dragonHeight) {
        super(dragonX, dragonY, dragonWidth, dragonHeight);

        try {
            greenDragonImg = ImageIO.read(new File(greenDragon));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        // drawing the dragon
        g2.drawImage(greenDragonImg, dragonX, dragonY, dragonWidth, dragonHeight, null);

    }
}

