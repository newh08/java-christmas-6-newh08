package christmas.model.domain.menu;

public class RequestOrder {
    private final String menuName;
    private final int quantity;

    public RequestOrder(String menuName, int quantity) {
        validateNameIsInMenu(menuName);
        this.menuName = menuName;
        this.quantity = quantity;
    }

    private void validateNameIsInMenu(String menuName) {
        if (MenuList.containName(menuName)) {
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
