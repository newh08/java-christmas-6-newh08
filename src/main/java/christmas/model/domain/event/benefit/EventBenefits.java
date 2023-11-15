package christmas.model.domain.event.benefit;

import static christmas.model.domain.event.benefit.gift.ChristmasGift.makeNoneGift;
import static christmas.model.domain.event.benefit.totaldiscount.ChristmasTotalDiscount.makeZeroTotalDiscount;

import christmas.model.domain.event.benefit.gift.Gift;
import christmas.model.domain.event.benefit.totaldiscount.TotalDiscount;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventBenefits {
    private final TotalDiscount totalDiscount;
    private final Gift gift;

    public EventBenefits(TotalDiscount totalDiscount, Gift gift) {
        this.totalDiscount = totalDiscount;
        this.gift = gift;
    }

    public static EventBenefits makeZeroEventBenefits() {
        return new EventBenefits(makeZeroTotalDiscount(), makeNoneGift());
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

    public int getDiscountBenefit() {
        return totalDiscount.calculateDiscountBenefit();
    }

    public int getTotalBenefit() {
        return totalDiscount.calculateDiscountBenefit() + gift.getGiftBenefit();
    }

}