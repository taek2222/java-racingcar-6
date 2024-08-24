package racingcar.controller;

import racingcar.domain.car.*;
import racingcar.validate.CarValidator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static racingcar.view.car.CarOutput.*;
import static racingcar.view.car.CarOutput.println;

public class RacingCarController {
    private final CarSetting carSetting = new CarSetting();
    private final CarValidator carValidator = new CarValidator();
    private final CarMove carMove = new CarMove();
    private final CarWinner carWinner = new CarWinner();

    public void run() {
        List<Car> carList = initCar();
        int playCount = initPlayCount();

        printResultStartMessage();
        for (int playing = 0; playing < playCount; playing++) {
            carMoves(carList);
            racingResult(carList);
        }

        int winnerDistance = carWinner.getWinnerDistance(carList);
        ArrayDeque<String> winnerList = carWinner.getWinnerList(carList, winnerDistance);
        printWinnerList(winnerList);
    }

    private List<Car> initCar() {
        printCarPlayCountInputMessage();
        String[] cars = carSetting.inputCarName();
        carValidator.carNameValidator(cars);

        List<Car> carList = new ArrayList<>();
        for (String car : cars)
            carList.add(carSetting.saveCar(car));

        return carList;
    }

    private int initPlayCount() {
        printCarNameInputMessage();
        return carSetting.inputCarPlayCount();
    }

    private void carMoves(List<Car> carList) {
        for (Car car : carList)
            carMove.moveCar(car);
    }

    private void racingResult(List<Car> carList) {
        for (Car car : carList) {
            printResultCarNameMessage(car.getName());
            printResultCarDistanceMessage(car.getDistance());
            println();
        }
        println();
    }
}
