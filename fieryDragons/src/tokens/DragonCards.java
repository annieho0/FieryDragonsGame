package tokens;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public abstract class DragonCards {
    public BufferedImage image;
    public String name;
    public int x, y;
    private String imagePath;

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
