package christmas.model.domain.order;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.EventStrategy;

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

    public EventStrategy applyEvent(EventStrategy eventStrategy, Date date) {
        eventStrategy.updateEventResult(requestOrders, totalOrderPrice, date);
        return eventStrategy;
    }

    public RequestOrders getRequestOrders() {
        return requestOrders;
    }

    public TotalOrderPrice getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
