package christmas.model.domain.event;

import static christmas.model.domain.event.EventBenefits.makeInitialConditionEventBenefits;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrders;
import christmas.model.domain.order.TotalOrderPrice;

public class ChristmasEventStrategy implements EventStrategy{
    private final EventBenefits eventBenefits;
    private Badge badge;

    public ChristmasEventStrategy(EventBenefits eventBenefits, Badge badge) {
        this.eventBenefits = eventBenefits;
        this.badge = badge;
    }

    public static ChristmasEventStrategy makeInitialConditionEventResults() {
        return new ChristmasEventStrategy(makeInitialConditionEventBenefits(), Badge.NONE);
    }

    public void updateEventResult(RequestOrders requestOrders, TotalOrderPrice totalOrderPrice, Date date) {
        eventBenefits.applyDiscount(requestOrders, date);
        eventBenefits.updateGift(totalOrderPrice);
        updateBadge();
    }

    private void updateBadge() {
        badge = Badge.getBadge(Math.abs(eventBenefits.getTotalBenefit()));
    }

    public EventBenefits getEventBenefit() {
        return eventBenefits;
    }

    public Badge getBadge() {
        return badge;
    }
}