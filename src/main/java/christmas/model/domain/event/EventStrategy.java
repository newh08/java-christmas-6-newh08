package christmas.model.domain.event;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrders;
import christmas.model.domain.order.TotalOrderPrice;

public interface EventStrategy {
    void updateEventResult(RequestOrders requestOrders, TotalOrderPrice totalOrderPrice, Date date);

    Badge getBadge();

    EventBenefits getEventBenefit();
}
