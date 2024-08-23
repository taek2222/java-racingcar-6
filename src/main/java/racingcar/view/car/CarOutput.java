package racingcar.view.car;

import racingcar.view.Output;

import java.util.ArrayDeque;

import static racingcar.view.car.CarViewConstant.*;

public class CarOutput {

    public static void printCarNameInputMessage() {
        Output.println(CAR_NAME_INPUT.getMessage());
    }

    public static void printCarPlayCountInputMessage() {
        Output.println(CAR_PLAY_COUNT_INPUT.getMessage());
    }

    public static void printResultStartMessage() {
        Output.println(CAR_PLAY_RESULT.getMessage());
    }

    public static void printResultCarNameMessage(String carName) {
        Output.print(carName + " : ");
    }

    public static void printResultCarDistanceMessage(int distance) {
        for (int move = 0; move < distance; move++)
            Output.print("-");
    }

    public static void printWinnerList(ArrayDeque<String> winnerList) {
        Output.print(CAR_WINNER_RESULT.getMessage());

        while (true) {
            String name = winnerList.poll();
            Output.print(name);

            if (winnerList.isEmpty())
                break;

            Output.print(", ");
        }
    }

    public static void println() {
        Output.println("");
    }
}
