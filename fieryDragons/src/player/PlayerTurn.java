package player;

public enum PlayerTurn {
    PINK,
    PURPLE,
    BLUE,
    GREEN;

    public PlayerTurn next() {
        return values()[(ordinal() + 1) % values().length];
    }
}

