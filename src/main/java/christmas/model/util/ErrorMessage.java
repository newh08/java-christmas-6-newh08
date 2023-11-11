package christmas.model.util;

public enum ErrorMessage {
    INVALID_DATE_MESSAGE ("[ERROR]", "유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    OVER_MAX_MENU_MESSAGE ("[ERROR]", "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요."),
    WRONG_ORDER_ONLY_BEVERAGE ("[ERROR]", "음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요."),
    INVALID_ORDER_MESSAGE ("[ERROR]", "유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String suffix;
    private final String errorMessage;

    ErrorMessage(String suffix, String errorMessage) {
        this.suffix = suffix;
        this.errorMessage = errorMessage;
    }

    public String makeErrorMessage() {
        return String.join(" ", suffix, errorMessage);
    }
}
