
/**
 * Abstract Base class for Actions. These represent events that happen in the game and things that dragons can do.
 *
 * Created by:
 * @author Navya Balraj
 */
public abstract class Action {

  /**
   * Execute method which will execute the effects of the action.
   * @return String stating the success or failure of the action.
   */
  public abstract String execute();

}