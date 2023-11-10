package christmas.model.domain.event;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;
import java.util.stream.Stream;

public class EventBenefits {
    private final TotalDiscount totalDiscount;
    private Gift gift;

    public EventBenefits(TotalDiscount totalDiscount, Gift gift) {
        this.totalDiscount = totalDiscount;
        this.gift = gift;
    }

    public void applyDiscount(OrderedMenus orderedMenus, Date date) {
        totalDiscount.applyDiscount(orderedMenus, date);
    }

    public void updateGift(Gift gift) {
        this.gift = gift;
    }

    public Stream<String> makeBenefitMessageStream() {
        Stream<String> discountBenefitMessage = totalDiscount.makeMessageStream();
        Stream<String> giftBenefitMessage = gift.getGiftBenefitMessage();
        return Stream.concat(discountBenefitMessage, giftBenefitMessage);
    }

    public int getTotalDiscount() {
        return totalDiscount.getTotalDiscount();
    }

    public String getGiftMessage() {
        return gift.getGiftMessage();
    }
}
