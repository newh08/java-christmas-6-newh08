package christmas.model.domain.order;

import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.menu.MenuCategory;

public class OrderedMenus {

    private final RequestOrders requestOrders;
    private final TotalOrderPrice totalOrderPrice;

    public OrderedMenus(RequestOrders requestOrders) {
        this.requestOrders = requestOrders;
        totalOrderPrice = updatePrice();
        updatePrice();
    }

    private TotalOrderPrice updatePrice() {
        return requestOrders.updatePrice();
    }

    public Gift makeGift() {
        return totalOrderPrice.makeGiftPerTotalOrderPrice();
    }

    public int getNumberOfSpecificCatalogOrder(MenuCategory menuCategory) {
        return requestOrders.getNumberOfSpecificCatalogOrder(menuCategory);
    }

    public RequestOrders getRequestOrders() {
        return requestOrders;
    }

    public TotalOrderPrice getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
