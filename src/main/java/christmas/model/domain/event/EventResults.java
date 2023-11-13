package christmas.model.domain.event;

import static christmas.model.domain.event.EventBenefits.makeInitialConditionEventBenefits;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.order.OrderedMenus;

public class EventResults {
    private final EventBenefits eventBenefits;
    private int totalBenefitAmount;
    private Badge badge;

    public EventResults(EventBenefits eventBenefits, int totalBenefitAmount, Badge badge) {
        this.eventBenefits = eventBenefits;
        this.totalBenefitAmount = totalBenefitAmount;
        this.badge = badge;
    }

    public static EventResults makeInitialConditionEventResults() {
        return new EventResults(makeInitialConditionEventBenefits(), 0, Badge.NONE);
    }

    public void updateEventResult(OrderedMenus orderedMenus, Date date) {
        eventBenefits.applyDiscount(orderedMenus, date);
        Gift gift = orderedMenus.makeGift();
        eventBenefits.updateGift(gift);
        updateTotalBenefitAmount(gift);
        updateBadge();
    }

    private void updateTotalBenefitAmount(Gift gift) {
        totalBenefitAmount = eventBenefits.getDiscountBenefit() + gift.getGiftPrice();
    }

    private void updateBadge() {
        badge = Badge.getBadge(Math.abs(totalBenefitAmount));
    }

    public EventBenefits getEventBenefit() {
        return eventBenefits;
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public Badge getBadge() {
        return badge;
    }
}