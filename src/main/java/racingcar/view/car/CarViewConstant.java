package racingcar.view.car;

public enum CarViewConstant {
    CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    CAR_PLAY_COUNT_INPUT("시도할 횟수는 몇회인가요?"),
    CAR_PLAY_RESULT("실행 결과"),
    CAR_WINNER_RESULT("최종 우승자 : ");

    private final String message;

    CarViewConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
