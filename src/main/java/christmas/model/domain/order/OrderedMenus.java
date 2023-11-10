package christmas.model.domain.order;

import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.menu.MenuCategory;
import java.util.Collections;
import java.util.List;

public class OrderedMenus {
    private final List<RequestOrder> requestOrders;
    private final TotalOrderPrice totalOrderPrice;

    public OrderedMenus(List<RequestOrder> requestOrderList) {
        this.requestOrders = requestOrderList;
        totalOrderPrice = new TotalOrderPrice();
        updatePrice();
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
