package christmas.model.domain.order;

import christmas.model.domain.menu.Menu;
import christmas.model.domain.menu.MenuCategory;

public class RequestOrder {
    private static final String ORDER_MESSAGE = "%s %d개";
    private final Menu menu;
    private final int quantity;

    public RequestOrder(String menuName, int quantity) {
        this.menu = Menu.getMenuByName(menuName);
        this.quantity = quantity;
    }

    public boolean checkCatalog(MenuCategory menuCategory) {
        return menu.checkCategory(menuCategory);
    }

    public int getOrderPrice() {
        return menu.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format(ORDER_MESSAGE, menu.getName(), quantity);
    }
}
