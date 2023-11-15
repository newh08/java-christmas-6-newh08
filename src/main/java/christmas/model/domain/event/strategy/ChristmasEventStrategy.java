package christmas.model.domain.event.strategy;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.Badge;
import christmas.model.domain.event.benefit.gift.ChristmasGift;
import christmas.model.domain.event.benefit.EventBenefits;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.event.benefit.gift.Gift;
import christmas.model.domain.event.benefit.totaldiscount.ChristmasTotalDiscount;
import christmas.model.domain.event.benefit.totaldiscount.TotalDiscount;
import christmas.model.domain.order.RequestOrders;
import christmas.model.domain.order.TotalOrderPrice;

public class ChristmasEventStrategy implements EventStrategy {
    private final int CHRISTMAS_EVENT_APPLY_MINIMUM_PRICE = 10000;

    private final TotalDiscount christmasTotalDiscount;

    public ChristmasEventStrategy(ChristmasTotalDiscount christmasTotalDiscount) {
        this.christmasTotalDiscount = christmasTotalDiscount;
    }

    @Override
    public EventResults updateEventResult(RequestOrders requestOrders, Date date) {
        christmasTotalDiscount.applyDiscount(requestOrders, date);
        TotalOrderPrice totalOrderPrice = requestOrders.getTotalOrderPrice();
        Gift gift = ChristmasGift.makeChristmasGift(totalOrderPrice);

        EventBenefits eventBenefits = new EventBenefits(christmasTotalDiscount, gift);
        Badge badge = Badge.getBadge(Math.abs(eventBenefits.getTotalBenefit()));
        return new EventResults(eventBenefits, badge);
    }

    @Override
    public int getMinimumOrderPrice() {
        return CHRISTMAS_EVENT_APPLY_MINIMUM_PRICE;
    }

}