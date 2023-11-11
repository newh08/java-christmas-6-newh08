package christmas.model.util;

public class MyIllegalArgumentException extends IllegalArgumentException {

    public MyIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.makeErrorMessage());
    }
}
