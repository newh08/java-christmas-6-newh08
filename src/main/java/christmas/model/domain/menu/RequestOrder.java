package christmas.model.domain.menu;

public class RequestOrder {
    private final Menu menu;
    private final int quantity;

    public RequestOrder(String menuName, int quantity) {
        this.menu = Menu.getMenuByName(menuName);
        this.quantity = quantity;
    }
}
