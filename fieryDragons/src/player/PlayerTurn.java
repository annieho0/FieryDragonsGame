package player;

/**
 * The PlayerTurn enum represents the turn of players in the game.
 */
public enum PlayerTurn {
    /** Represents the turn of the pink player. */
    PINK,
    /** Represents the turn of the purple player. */
    PURPLE,
    /** Represents the turn of the blue player. */
    BLUE,
    /** Represents the turn of the green player. */
    GREEN;

    /**
     * Gets the next player turn in a cyclic order.
     *
     * @return The next player turn.
     */
    public PlayerTurn next() {
        return values()[(ordinal() + 1) % values().length];
    }
}
