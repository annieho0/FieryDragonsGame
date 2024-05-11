package player;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Player extends Entity{
    protected GamePanel gp;
    protected BufferedImage dragonImage;

    public Player(GamePanel gp, String imagePath, int startX, int startY) {
        this.gp = gp;
        setDefaultValues(startX, startY);
        getDragonImage(imagePath);
    }

    public abstract void update();

    public void draw(Graphics2D g2) {
        g2.drawImage(dragonImage, x, y, gp.tileSize, gp.tileSize, null);
    }

    protected void getDragonImage(String imagePath) {
        try {
            dragonImage = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setDefaultValues(int startX, int startY) {
        x = startX * gp.tileSize;
        y = startY * gp.tileSize;
    }
    public void setCurrentPosition(int positionX, int positionY){
        x = positionX * gp.tileSize;
        y = positionY * gp.tileSize;
    }

}
//    GamePanel gp;
//    public Player(GamePanel gp){
//        this.gp = gp;
//        setDefaultValues(4,12);
//        getPlayerImage();
//
//    }
//    public void setDefaultValues(int startX, int startY){
//        x = startX * gp.tileSize;
//        y = startY * gp.tileSize;
//    }
//    public void getPlayerImage(){
//        try{
//            dragon = ImageIO.read(getClass().getResourceAsStream("/players/BlueDragon.png"));
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//    public void update(){}
//    public void draw(Graphics2D g2){
//        BufferedImage image = dragon;
//        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
//    }
//}
