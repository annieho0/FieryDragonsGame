package boardCards;

import main.GamePanel;
import tokens.*;
import util.FindCoordinatesWithValue;
import java.util.*;

/**
 * The AssetSetter class is responsible for setting objects (DragonCards) on the game board.
 */
public class AssetSetter {
    private static GamePanel gp;
    private static FindCoordinatesWithValue findcoor;
    private static Map<String, DragonCards> coordinateObjectMap;

    /**
     * Constructs an AssetSetter object.
     *
     * @param gp The GamePanel object associated with the game.
     */
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
        findcoor = new FindCoordinatesWithValue();
        coordinateObjectMap = new HashMap<String, DragonCards>();
    }

    /**
     * Sets objects (DragonCards) on the game board based on specified coordinates.
     */
    public static void setObject() {
        // Get coordinates with value 1
        List<int[]> coordinatesWithOne = findcoor.getCoordinatesWithOne();
        Collections.shuffle(coordinatesWithOne);

        // Specific coordinates
        List<int[]> specificCoordinates = Arrays.asList(
                new int[]{2, 12},
                new int[]{2, 4},
                new int[]{12, 4},
                new int[]{12, 12}
        );

        // Object types
        List<DragonCards> objects = Arrays.asList(
                new OBJ_Spider(),
                new OBJ_Bat(),
                new OBJ_Egg(),
                new OBJ_Lizard()
        );

        // Shuffle specific coordinates and objects
        Collections.shuffle(specificCoordinates);
        Collections.shuffle(objects);

        // Place the objects at specific coordinates
        for (int i = 0; i < specificCoordinates.size(); i++) {
            int[] coordinate = specificCoordinates.get(i);
            int row = coordinate[0];
            int col = coordinate[1];
            DragonCards object = objects.get(i);

            placeObject(object, row, col);
            coordinateObjectMap.put(Arrays.toString(coordinate), object);
        }

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
                coordinateObjectMap.put(Arrays.toString(coordinate), object);
            }
        }
    }

    /**
     * Places a DragonCards object on the game board at specified row and column.
     *
     * @param object The DragonCards object to be placed.
     * @param row    The row index where the object will be placed.
     * @param col    The column index where the object will be placed.
     */
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

    /**
     * Retrieves the DragonCards object at the specified coordinate.
     *
     * @param coordinate The coordinate of the object to retrieve.
     * @return The DragonCards object at the specified coordinate, or null if not found.
     */
    public static DragonCards getObjectAtCoordinate(String coordinate) {
        return coordinateObjectMap.get(coordinate);
    }
}
