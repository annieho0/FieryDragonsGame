package boardCards;

import main.GamePanel;
import tokens.*;
import util.FindCoordinatesWithValue;

import java.util.*;

public class AssetSetter {
    private static GamePanel gp;
    private static FindCoordinatesWithValue findcoor;
    private static Map<String, DragonCards> coordinateObjectMap;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
        findcoor = new FindCoordinatesWithValue();
        coordinateObjectMap = new HashMap<String, DragonCards>();

    }

    public static void setObject() {
        List<int[]> coordinatesWithOne = findcoor.getCoordinatesWithOne();
        Collections.shuffle(coordinatesWithOne);

        // Track the count of placed objects
        int spiderCount = 0;
        int batCount = 0;
        int eggCount = 0;
        int lizardCount = 0;

        // Place objects on each coordinate with value 1
        for (int[] coordinate : coordinatesWithOne) {
            int row = coordinate[0];
            int col = coordinate[1];

            DragonCards object = null;
            // Choose the object type to place based on the count of each object
            if (spiderCount < 6) {
                object = new OBJ_Spider();
                placeObject(new OBJ_Spider(), row, col);
                spiderCount++;
            } else if (batCount < 6) {
                object = new OBJ_Bat();
                placeObject(new OBJ_Bat(), row, col);
                batCount++;
            } else if (eggCount < 6) {
                object = new OBJ_Egg();
                placeObject(new OBJ_Egg(), row, col);
                eggCount++;
            } else if (lizardCount < 6) {
                object = new OBJ_Lizard();
                placeObject(new OBJ_Lizard(), row, col);
                lizardCount++;
            }
            if (object != null) {
                // Store the object at its corresponding coordinates

                coordinateObjectMap.put(Arrays.toString(coordinate), object);}
        }
    }

    private static void placeObject(DragonCards object, int row, int col) {
        int index = 0;
        while (gp.obj[index] != null && index < gp.obj.length) {
            index++;
        }

        // Check if there is space available in gp.obj array
        if (index < gp.obj.length) {
            // Set the object's coordinates
            gp.obj[index] = object;
            gp.obj[index].x = col * gp.tileSize;
            gp.obj[index].y = row * gp.tileSize;
        } else {
            System.out.println("No space available in gp.obj array to place object.");
        }
    }
    public static DragonCards getObjectAtCoordinate(String coordinate) {
//        System.out.println(coordinateObjectMap.get(coordinate));
        return coordinateObjectMap.get(coordinate);
    }
}

