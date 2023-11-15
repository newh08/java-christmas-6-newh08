package christmas.model.domain.order;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.event.strategy.EventStrategy;

public class OrderedMenus {

    private final RequestOrders requestOrders;
    private final TotalOrderPrice totalOrderPrice;

    public OrderedMenus(RequestOrders requestOrders) {
        this.requestOrders = requestOrders;
        totalOrderPrice = updatePrice();
    }

    private TotalOrderPrice updatePrice() {
        return requestOrders.updatePrice();
    }

    public EventResults applyEvent(EventStrategy eventStrategy, Date date) {
        if (totalOrderPrice.isUnderMinimumEventPrice(eventStrategy)) {
            return EventResults.makeZeroEventResults();
        }
        return eventStrategy.updateEventResult(requestOrders, date);
    }

    public RequestOrders getRequestOrders() {
        return requestOrders;
    }

    public TotalOrderPrice getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
