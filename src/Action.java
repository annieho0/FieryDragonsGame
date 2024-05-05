
/**
 * Abstract Base class for Actions. These represent events that happen in the game and things that dragons can do.
 */
public abstract class Action {

  /**
   * Execute method which will execute the effects of the action. It returns a String stating the success or failure of the action.
   */
  public abstract String execute();

}