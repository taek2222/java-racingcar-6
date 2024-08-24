package racingcar.validate;

public class CarValidator {

    public void carNameValidator(String[] cars) {
        for (String car : cars)
            if (car.length() > 5)
                throw new IllegalArgumentException();
    }
}
