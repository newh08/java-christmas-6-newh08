package christmas.model.domain.event;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.event.benefit.ChristmasTotalDiscount;
import christmas.model.domain.event.benefit.TotalDiscount;
import christmas.model.domain.order.RequestOrders;
import christmas.model.domain.order.TotalOrderPrice;

public class ChristmasEventStrategy implements EventStrategy{
    private final TotalDiscount christmasTotalDiscount;

    public ChristmasEventStrategy(ChristmasTotalDiscount christmasTotalDiscount) {
        this.christmasTotalDiscount = christmasTotalDiscount;
    }

    public EventResults updateEventResult(RequestOrders requestOrders, Date date) {
        christmasTotalDiscount.applyDiscount(requestOrders, date);
        TotalOrderPrice totalOrderPrice = requestOrders.updatePrice();
        Gift gift = totalOrderPrice.makeGiftPerTotalOrderPrice();

        EventBenefits eventBenefits = new EventBenefits(christmasTotalDiscount, gift);
        Badge badge1 = updateBadge(eventBenefits);
        return new EventResults(eventBenefits, badge1);
    }

    private Badge updateBadge(EventBenefits eventBenefits) {
        return Badge.getBadge(Math.abs(eventBenefits.getTotalBenefit()));
    }

}