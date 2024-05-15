package player;

import main.GamePanel;

/**
 * The PinkDragon class represents a player-controlled pink dragon in the game.
 */
public class PinkDragon extends Player {

    /**
     * Constructs a PinkDragon object.
     *
     * @param gp         The GamePanel associated with the game.
     * @param startX     The initial x-coordinate of the pink dragon.
     * @param startY     The initial y-coordinate of the pink dragon.
     * @param playerTurn The player turn object associated with the pink dragon.
     */
    public PinkDragon(GamePanel gp, int startX, int startY, PlayerTurn playerTurn) {
        super(gp, "/players/PinkDragon.png", startX, startY, playerTurn);
    }

    /**
     * Overrides the update method to update the pink dragon's state.
     */
    @Override
    public void update() {
    }
}
