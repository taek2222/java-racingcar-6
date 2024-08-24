package racingcar.controller;

import racingcar.domain.car.*;
import racingcar.service.car.*;
import racingcar.validate.CarValidator;

public class RacingCarController {
    private final CarSetting carSetting = new CarSetting();
    private final CarValidator carValidator = new CarValidator();
    private final CarMove carMove = new CarMove();
    private final CarWinner carWinner = new CarWinner();
    private final CarService carService = new CarService(carSetting, carValidator, carMove, carWinner);

    public void run() {
        carService.processCarPlay();
    }
}
