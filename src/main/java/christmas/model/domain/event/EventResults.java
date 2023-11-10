package christmas.model.domain.event;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrders;

public class EventResults {
    private final TotalDiscount totalDiscount;
    private Gift gift;
    private int totalBenefitAmount;
    private Badge badge;

    public EventResults(TotalDiscount totalDiscount) {
        this.totalDiscount = new TotalDiscount();
    }

    public void updateEventResult(RequestOrders requestOrders, Date date) {
        totalDiscount.applyDiscount(requestOrders, date);
        gift = new Gift(requestOrders.getTotalPrice());
        totalBenefitAmount = totalDiscount.getTotalDiscount() + gift.getGiftPrice();
        badge = Badge.getBadge(totalBenefitAmount);
    }
}
