package christmas.model.domain.event.strategy;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.RequestOrders;

public interface EventStrategy {
    EventResults updateEventResult(RequestOrders requestOrders, Date date);

    int getMinimumOrderPrice();
}
