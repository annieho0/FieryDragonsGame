package player;

import main.GamePanel;

/**
 * The BlueDragon class represents a player-controlled blue dragon in the game.
 */
public class BlueDragon extends Player {

    /**
     * Constructs a BlueDragon object.
     *
     * @param gp         The GamePanel associated with the game.
     * @param startX     The initial x-coordinate of the blue dragon.
     * @param startY     The initial y-coordinate of the blue dragon.
     * @param playerTurn The player turn object associated with the blue dragon.
     */
    public BlueDragon(GamePanel gp, int startX, int startY, PlayerTurn playerTurn) {
        super(gp, "/players/BlueDragon.png", startX, startY, playerTurn);
    }

    /**
     * Overrides the update method to update the blue dragon's state.
     */
    @Override
    public void update() {
    }
}
