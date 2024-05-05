import javax.swing.SwingUtilities;
/**
 * The main class to start the game which simply uses Java Swing utilities to call the GameLogic class which starts the game.
 *
 * Created by:
 * @author Navya Balraj
 */
public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        GameLogic gameLogic = new GameLogic();
      }
    });
  }
}