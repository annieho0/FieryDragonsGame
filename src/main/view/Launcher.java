package main.view;

/**
 * The Launcher class is the entry point of the Fiery Dragon game.
 * It creates an instance of the Display class to start the game.
 */
public class Launcher {

    /**
     * The main method, which is the entry point of the program.
     * It creates a Display object to initialize the game window.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a new Display object with dimensions 800x600
        Display display = new Display(800, 600);
    }
}
