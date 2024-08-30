package racingcar.view.car;

import racingcar.view.Output;

import java.util.ArrayDeque;

public class CarOutput {
    static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String CAR_PLAY_COUNT_INPUT = "시도할 횟수는 몇회인가요?";
    static final String CAR_PLAY_RESULT = "실행 결과";
    static final String CAR_WINNER_RESULT = "최종 우승자 : ";

    public static void printCarNameInputMessage() {
        Output.println(CAR_NAME_INPUT);
    }

    public static void printCarPlayCountInputMessage() {
        Output.println(CAR_PLAY_COUNT_INPUT);
    }

    public static void printResultStartMessage() {
        Output.println(CAR_PLAY_RESULT);
    }

    public static void printResultCarNameMessage(String carName) {
        Output.print(carName + " : ");
    }

    public static void printResultCarDistanceMessage(int distance) {
        for (int move = 0; move < distance; move++)
            Output.print("-");
    }

    public static void printWinnerList(ArrayDeque<String> winnerList) {
        Output.print(CAR_WINNER_RESULT);

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
