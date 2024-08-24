package racingcar.domain.car;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void saveDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
