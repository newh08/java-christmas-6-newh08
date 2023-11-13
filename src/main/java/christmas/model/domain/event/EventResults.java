package christmas.model.domain.event;

import static christmas.model.domain.event.EventBenefits.makeInitialConditionEventBenefits;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;

public class EventResults {
    private final EventBenefits eventBenefits;
    private Badge badge;

    public EventResults(EventBenefits eventBenefits, Badge badge) {
        this.eventBenefits = eventBenefits;
        this.badge = badge;
    }

    public static EventResults makeInitialConditionEventResults() {
        return new EventResults(makeInitialConditionEventBenefits(), Badge.NONE);
    }

    public void updateEventResult(OrderedMenus orderedMenus, Date date) {
        eventBenefits.applyDiscount(orderedMenus, date);
        eventBenefits.updateGift(orderedMenus);
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