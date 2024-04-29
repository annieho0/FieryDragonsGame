package boardCards;


import main.GamePanel;
import tokens.OBJ_Bat;
import tokens.OBJ_Spider;
import util.FindCoordinatesWithValue;

import java.util.Random;


public class AssetSetter {
    private static GamePanel gp;
    private static Random rand;
    private static FindCoordinatesWithValue findcoor;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
        rand = new Random();
        findcoor = new FindCoordinatesWithValue();
    }

    //    public static void setObject() {
//        gp.obj[0] = new OBJ_Spider();
//        gp.obj[0].x = rand.nextInt(gp.maxScreenRow) * gp.tileSize;
//        gp.obj[0].y = rand.nextInt(gp.maxScreenCol) * gp.tileSize;
//    }
    public static void setObject() {
        gp.obj[0] = new OBJ_Spider();
        gp.obj[0].x = rand.nextInt(gp.maxScreenRow) * gp.tileSize;
        gp.obj[0].y = rand.nextInt(gp.maxScreenCol) * gp.tileSize;
        boolean[][] coordinatesWithOne = findcoor.getCoordinatesWithOne();
        for (int row = 0; row < coordinatesWithOne.length; row++) {
            for (int col = 0; col < coordinatesWithOne[row].length; col++) {
                if (coordinatesWithOne[row][col]) {
                    OBJ_Spider spider = new OBJ_Spider();
                    spider.x = col * gp.tileSize; // Assuming tileSize is the size of each tile
                    spider.y = row * gp.tileSize; // Assuming tileSize is the size of each tile

                }
            }
        }
    }
}