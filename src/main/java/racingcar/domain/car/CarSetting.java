package racingcar.domain.car;

import static racingcar.view.Input.*;

public class CarSetting {

    public String[] inputCarName() {
        return readLine().split(",");
    }

    public int inputCarPlayCount() {
        return Integer.parseInt(readLine());
    }

    public Car saveCar(String car) {
        return new Car(car);
    }
}
