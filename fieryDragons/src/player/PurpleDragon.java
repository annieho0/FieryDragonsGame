package player;

import main.GamePanel;

/**
 * The PurpleDragon class represents a player-controlled purple dragon in the game.
 */
public class PurpleDragon extends Player {

    /**
     * Constructs a PurpleDragon object.
     *
     * @param gp         The GamePanel associated with the game.
     * @param startX     The initial x-coordinate of the purple dragon.
     * @param startY     The initial y-coordinate of the purple dragon.
     * @param playerTurn The player turn object associated with the purple dragon.
     */
    public PurpleDragon(GamePanel gp, int startX, int startY, PlayerTurn playerTurn) {
        super(gp, "/players/PurpleDragon.png", startX, startY, playerTurn);
    }

    /**
     * Overrides the update method to update the purple dragon's state.
     */
    @Override
    public void update() {
    }
}
