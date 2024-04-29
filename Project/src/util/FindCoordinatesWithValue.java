package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindCoordinatesWithValue {
    private boolean[][] coordinatesWithOne;

    public FindCoordinatesWithValue() {
        // Specify the path to your text file
        String filePath = "Project/res/maps/map.txt";

        try {
            // Read the text file
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Initialize coordinatesWithOne array
            int rows = countRows(file);
            int cols = countCols(file);
            coordinatesWithOne = new boolean[rows][cols];

            int row = 0;

            // Loop through each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");

                // Loop through each value in the line
                // Loop through each value in the line
                for (int col = 0; col < values.length; col++) {
                    // Check if the value is not empty and is equal to 1
                    if (!values[col].isEmpty() && Integer.parseInt(values[col]) == 1) {
                        coordinatesWithOne[row][col] = true;
                    }
                }

                row++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    // Method to count the number of rows in the file
    private int countRows(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rows = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            rows++;
        }
        scanner.close();
        return rows;
    }

    // Method to count the number of columns in the file
    private int countCols(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        int cols = line.split(" ").length;
        scanner.close();
        return cols;
    }

    // Getter method to retrieve the coordinatesWithOne array
    public boolean[][] getCoordinatesWithOne() {
        return coordinatesWithOne;
    }
}

