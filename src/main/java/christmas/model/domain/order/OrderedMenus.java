package christmas.model.domain.order;

import christmas.model.domain.event.Gift;
import christmas.model.domain.menu.MenuCategory;
import java.util.Collections;
import java.util.List;

public class OrderedMenus {
    private final List<RequestOrder> requestOrders;
    private final Price totalPrice;

    public OrderedMenus(List<RequestOrder> requestOrderList) {
        this.requestOrders = requestOrderList;
        totalPrice = new Price();
        updatePrice();
    }

    private void updatePrice() {
        for (RequestOrder requestOrder : requestOrders) {
            totalPrice.updatePrice(requestOrder);
        }
    }

    public Gift makeGift() {
        return totalPrice.makeGiftAccordingOrderPrice();
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

    public Price getTotalPrice() {
        return totalPrice;
    }
}
