package christmas.model.domain.order;

import static christmas.model.util.ErrorMessage.OVER_MAX_MENU_MESSAGE;
import static christmas.model.util.ErrorMessage.WRONG_ORDER_ONLY_BEVERAGE;

import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.menu.MenuCategory;
import christmas.model.util.MyIllegalArgumentException;
import java.util.Collections;
import java.util.List;

public class OrderedMenus {
    private static final int MAX_NUMBER_OF_MENU = 20;

    private final List<RequestOrder> requestOrders;
    private final TotalOrderPrice totalOrderPrice;

    public OrderedMenus(List<RequestOrder> requestOrders) {
        validateRequestOrders(requestOrders);
        this.requestOrders = requestOrders;
        totalOrderPrice = new TotalOrderPrice();
        updatePrice();
    }

    private void validateRequestOrders(List<RequestOrder> requestOrders) {
        validateTotalOrderQuantity(requestOrders);
        validateMenuContainNonBeverage(requestOrders);
    }

    private void validateTotalOrderQuantity(List<RequestOrder> requestOrders) {
        int totalMenuQuantity = requestOrders.stream()
                .mapToInt(RequestOrder::getQuantity)
                .sum();
        if (totalMenuQuantity > MAX_NUMBER_OF_MENU) {
            throw new MyIllegalArgumentException(OVER_MAX_MENU_MESSAGE);
        }
    }

    private void validateMenuContainNonBeverage(List<RequestOrder> requestOrders) {
        boolean isAllBeverage = requestOrders.stream()
                .allMatch(requestOrder -> requestOrder.checkCatalog(MenuCategory.BEVERAGE));
        if (isAllBeverage) {
            throw new MyIllegalArgumentException(WRONG_ORDER_ONLY_BEVERAGE);
        }
    }

    private void updatePrice() {
        for (RequestOrder requestOrder : requestOrders) {
            totalOrderPrice.updateTotalOrderPrice(requestOrder);
        }
    }

    public Gift makeGift() {
        return totalOrderPrice.makeGiftPerTotalOrderPrice();
    }

    public int getNumberOfSpecificCatalogOrder(MenuCategory menuCategory) {
        return requestOrders.stream()
                .filter(order -> order.checkCatalog(menuCategory))
                .mapToInt(RequestOrder::getQuantity)
                .sum();
    }

    public List<RequestOrder> getRequestOrders() {
        return Collections.unmodifiableList(requestOrders);
    }

    public TotalOrderPrice getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
