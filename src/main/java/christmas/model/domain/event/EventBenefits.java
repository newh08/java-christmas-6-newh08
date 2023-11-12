package christmas.model.domain.event;

import static christmas.model.domain.event.benefit.Gift.makeInitialConditionGift;
import static christmas.model.domain.event.benefit.TotalDiscount.makeInitialConditionTotalDiscount;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.event.benefit.TotalDiscount;
import christmas.model.domain.order.OrderedMenus;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventBenefits {
    private final TotalDiscount totalDiscount;
    private Gift gift;

    public EventBenefits(TotalDiscount totalDiscount, Gift gift) {
        this.totalDiscount = totalDiscount;
        this.gift = gift;
    }

    public static EventBenefits makeInitialConditionEventBenefits() {
        return new EventBenefits(makeInitialConditionTotalDiscount(), makeInitialConditionGift());
    }

    public void applyDiscount(OrderedMenus orderedMenus, Date date) {
        totalDiscount.applyDiscount(orderedMenus, date);
    }

    public void updateGift(Gift gift) {
        this.gift = gift;
    }

    public String makeBenefitMessage() {
        Stream<String> discountBenefitMessage = totalDiscount.makeDiscountBenefitMessageStream();
        Stream<String> giftBenefitMessage = gift.makeGiftBenefitMessageStream();
        return Stream.concat(discountBenefitMessage, giftBenefitMessage)
                .collect(Collectors.joining("\n"));
    }

    public String getGiftMessage() {
        return gift.makeGiftMessage();
    }

    public int getTotalDiscount() {
        return totalDiscount.getTotalDiscount();
    }
}
