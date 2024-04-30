package boardCards;


import main.GamePanel;
import tokens.*;
import util.FindCoordinatesWithValue;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
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
    public static void setObject() {
        boolean[][] coordinatesWithOne = findcoor.getCoordinatesWithOne();

        // Create a list of all valid coordinates
        ArrayList<Coordinate> validCoordinates = new ArrayList<>();
        for (int row = 0; row < coordinatesWithOne.length; row++) {
            for (int col = 0; col < coordinatesWithOne[0].length; col++) {
                if (coordinatesWithOne[row][col]) {
                    validCoordinates.add(new Coordinate(row, col));
                }
            }
        }

        // Shuffle the list of coordinates
        Collections.shuffle(validCoordinates);

        // Place objects on each coordinate
        placeObjects(validCoordinates);
    }

    private static void placeObjects(ArrayList<Coordinate> validCoordinates) {
        int numObjectsPerType = 6; // Each object type appears six times
        int totalObjects = 4 * numObjectsPerType; // Total number of objects to be placed
        int objectIndex = 0;

        // Place spiders
        for (int i = 0; i < numObjectsPerType; i++) {
            gp.obj[objectIndex] = new OBJ_Spider();
            Coordinate coordinate = findValidSpiderCoordinate(validCoordinates, objectIndex);
            gp.obj[objectIndex].x = coordinate.col * gp.tileSize;
            gp.obj[objectIndex].y = coordinate.row * gp.tileSize;
            objectIndex++;
        }

        // Place bats
        for (int i = 0; i < numObjectsPerType; i++) {
            gp.obj[objectIndex] = new OBJ_Bat();
            Coordinate coordinate = findValidBatCoordinate(validCoordinates);
            gp.obj[objectIndex].x = coordinate.col * gp.tileSize;
            gp.obj[objectIndex].y = coordinate.row * gp.tileSize;
            objectIndex++;
        }

        // Place eggs
        for (int i = 0; i < numObjectsPerType; i++) {
            gp.obj[objectIndex] = new OBJ_Egg();
            Coordinate coordinate = validCoordinates.remove(0);
            gp.obj[objectIndex].x = coordinate.col * gp.tileSize;
            gp.obj[objectIndex].y = coordinate.row * gp.tileSize;
            objectIndex++;
        }

        // Place lizards
        for (int i = 0; i < numObjectsPerType; i++) {
            gp.obj[objectIndex] = new OBJ_Lizard();
            Coordinate coordinate = validCoordinates.remove(0);
            gp.obj[objectIndex].x = coordinate.col * gp.tileSize;
            gp.obj[objectIndex].y = coordinate.row * gp.tileSize;
            objectIndex++;
        }
    }


    private static Coordinate findValidSpiderCoordinate(ArrayList<Coordinate> validCoordinates, int index) {
        for (Coordinate coordinate : validCoordinates) {
            if (!isAdjacentToAnySpider(coordinate)) {
                validCoordinates.remove(coordinate);
                return coordinate;
            }
        }
        // If no suitable coordinate is found, return the first available coordinate
        return validCoordinates.remove(0);
    }

    private static Coordinate findValidBatCoordinate(ArrayList<Coordinate> validCoordinates) {
        for (Coordinate coordinate : validCoordinates) {
            if (!isAdjacentToAnyBat(coordinate) && !isAdjacentToAnySpider(coordinate)) {
                validCoordinates.remove(coordinate);
                return coordinate;
            }
        }
        // If no suitable coordinate is found, return the first available coordinate
        return validCoordinates.remove(0);
    }

    private static boolean isAdjacentToAnySpider(Coordinate coordinate) {
        for (DragonCards spider : gp.obj) {
            if (spider != null && spider instanceof OBJ_Spider && isAdjacent(coordinate, (OBJ_Spider) spider)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAdjacentToAnyBat(Coordinate coordinate) {
        for (DragonCards bat : gp.obj) {
            if (bat != null && bat instanceof OBJ_Bat && isAdjacent(coordinate, (OBJ_Bat) bat)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAdjacent(Coordinate coord1, OBJ_Spider obj) {
        int dx = Math.abs(obj.x - coord1.col * gp.tileSize);
        int dy = Math.abs(obj.y - coord1.row * gp.tileSize);
        return (dx <= gp.tileSize && dy <= gp.tileSize);
    }

    private static boolean isAdjacent(Coordinate coord1, OBJ_Bat obj) {
        int dx = Math.abs(obj.x - coord1.col * gp.tileSize);
        int dy = Math.abs(obj.y - coord1.row * gp.tileSize);
        return (dx <= gp.tileSize && dy <= gp.tileSize);
    }

    private static class Coordinate {
        int row;
        int col;

        Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}