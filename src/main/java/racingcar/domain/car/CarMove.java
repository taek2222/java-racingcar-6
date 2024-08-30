package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.domain.car.GameConfig.*;

public class CarMove {

    public void moveCar(Car car) {
        int randomNumber = getRandomNumber();

        if(isaMove(randomNumber))
            car.saveDistance(car.getDistance() + 1);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_VALUE.getValue(), RANDOM_MAX_VALUE.getValue());
    }

    private boolean isaMove(int number) {
        return number >= MOVE_THRESHOLD.getValue();
    }
}
