package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FindCoordinatesWithValue {
    private List<int[]> coordinatesWithOne;

    public FindCoordinatesWithValue() {
        String mapPath = "/maps/map.txt";

        // Read the text file
        InputStream is = getClass().getResourceAsStream(mapPath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            coordinatesWithOne = new ArrayList<>();

            // Read each line of the file
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                // Split the line into characters
                String[] chars = line.split(" ");
                for (int col = 0; col < chars.length; col++) {
                    // Check if the character is '01'
                    if (chars[col].equals("01")) {
                        // If '01' is found, add its coordinates to the list
                        coordinatesWithOne.add(new int[]{row, col});
                    }
                }
                row++;
            }

            // Close the BufferedReader
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<int[]> getCoordinatesWithOne() {
        return coordinatesWithOne;
    }


}


