package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.validate.CarValidator;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final CarValidator carValidator = new CarValidator();

    public void run() {
        Output.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<Car> carList = new ArrayList<>();
        String[] cars = Input.readLine().split(",");
        carValidator.carNameValidator(cars);

        for (String car : cars)
            carList.add(new Car(car));

        Output.println("시도할 횟수는 몇회인가요?");
        int loopCount = Integer.parseInt(Input.readLine());


        Output.println("실행 결과");
        for (int i = 0; i < loopCount; i++) {
            for (Car car : carList) {
                int number = Randoms.pickNumberInRange(0, 9);

                if(number > 3)
                    car.processDistancePlus();
            }

            for (Car car : carList) {
                Output.print(car.getName() + " : ");
                for (int j = 0; j < car.getDistance(); j++) {
                    Output.print("-");
                }

                Output.println("");
            }
            Output.println("");
        }

        int max = 0;
        for (Car car : carList) {
            if (car.getDistance() > max) {
                max = car.getDistance();
            }
        }

        ArrayDeque<String> winner = new ArrayDeque<>();
        for (Car car : carList) {
            if (max == car.getDistance())
                winner.add(car.getName());
        }

        Output.print("최종 우승자 : ");
        while (true) {
            String name = winner.poll();
            Output.print(name);

            if (winner.isEmpty())
                break;
            Output.print(", ");
        }
    }
}
