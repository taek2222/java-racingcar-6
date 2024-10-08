package racingcar.domain.car;

public enum GameConfig {
    RANDOM_MIN_VALUE(0),
    RANDOM_MAX_VALUE(9),
    MOVE_THRESHOLD(4);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
