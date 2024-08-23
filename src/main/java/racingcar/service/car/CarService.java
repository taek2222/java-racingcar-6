package racingcar.service.car;

import racingcar.domain.car.*;
import racingcar.validate.CarValidator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static racingcar.view.car.CarOutput.*;

public class CarService {

    private final CarSetting carSetting;
    private final CarValidator carValidator;
    private final CarMove carMove;
    private final CarWinner carWinner;

    public CarService(CarSetting carSetting, CarValidator carValidator, CarMove carMove, CarWinner carWinner) {
        this.carSetting = carSetting;
        this.carValidator = carValidator;
        this.carMove = carMove;
        this.carWinner = carWinner;
    }

    public void processCarPlay() {
        printCarPlayCountInputMessage();
        String[] cars = carSetting.inputCarName();
        carValidator.carNameValidator(cars);

        List<Car> carList = new ArrayList<>();
        for (String car : cars)
            carList.add(carSetting.saveCar(car));

        printCarNameInputMessage();
        int playCount = carSetting.inputCarPlayCount();

        printResultStartMessage();
        for (int playing = 0; playing < playCount; playing++) {
            carMoves(carList);
            racingResult(carList);
        }

        int winnerDistance = carWinner.getWinnerDistance(carList);
        ArrayDeque<String> winnerList = carWinner.getWinnerList(carList, winnerDistance);
        printWinnerList(winnerList);
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
