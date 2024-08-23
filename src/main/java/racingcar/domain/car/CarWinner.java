package racingcar.domain.car;

import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;

public class CarWinner {

    public int getWinnerDistance(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public ArrayDeque<String> getWinnerList(List<Car> carList, int winnerValue) {
        return carList.stream()
                .filter(car -> car.getDistance() == winnerValue)
                .map(Car::getName)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
