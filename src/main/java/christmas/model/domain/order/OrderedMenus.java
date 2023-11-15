package christmas.model.domain.order;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.event.strategy.EventStrategy;

public class OrderedMenus {

    private final RequestOrders requestOrders;

    public OrderedMenus(RequestOrders requestOrders) {
        this.requestOrders = requestOrders;
    }

    public EventResults applyEvent(EventStrategy eventStrategy, Date date) {
        if (requestOrders.getTotalOrderPrice().isUnderMinimumEventPrice(eventStrategy)) {
            return EventResults.makeZeroEventResults();
        }
        return eventStrategy.updateEventResult(requestOrders, date);
    }

    public RequestOrders getRequestOrders() {
        return requestOrders;
    }
}
