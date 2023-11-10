package christmas.model.domain.event;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;

public class EventResults {
    private final TotalDiscount totalDiscount;
    private Gift gift;
    private int totalBenefitAmount;
    private Badge badge;

    public EventResults() {
        this.totalDiscount = new TotalDiscount();
        gift = new Gift(0);
        totalBenefitAmount = 0;
        badge = Badge.NONE;
    }

    public void updateEventResult(OrderedMenus orderedMenus, Date date) {
        totalDiscount.applyDiscount(orderedMenus, date);
        gift = orderedMenus.makeGift();
        totalBenefitAmount = totalDiscount.getTotalDiscount() + gift.getGiftPrice();
        badge = Badge.getBadge(totalBenefitAmount);
    }

    public TotalDiscount getTotalDiscount() {
        return totalDiscount;
    }

    public Gift getGift() {
        return gift;
    }

    public int getTotalBenefitAmount() {
        return totalBenefitAmount;
    }

    public Badge getBadge() {
        return badge;
    }
}
