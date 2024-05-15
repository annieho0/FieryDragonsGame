package player;

import main.GamePanel;

/**
 * The GreenDragon class represents a player-controlled green dragon in the game.
 */
public class GreenDragon extends Player {

    /**
     * Constructs a GreenDragon object.
     *
     * @param gp         The GamePanel associated with the game.
     * @param startX     The initial x-coordinate of the green dragon.
     * @param startY     The initial y-coordinate of the green dragon.
     * @param playerTurn The player turn object associated with the green dragon.
     */
    public GreenDragon(GamePanel gp, int startX, int startY, PlayerTurn playerTurn) {
        super(gp, "/players/GreenDragon.png", startX, startY, playerTurn);
    }

    /**
     * Overrides the update method to update the green dragon's state.
     */
    @Override
    public void update() {
    }
}
