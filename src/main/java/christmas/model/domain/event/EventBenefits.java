package christmas.model.domain.event;

import static christmas.model.domain.event.benefit.Gift.makeInitialConditionGift;
import static christmas.model.domain.event.benefit.ChristmasTotalDiscount.makeInitialConditionTotalDiscount;

import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.event.benefit.TotalDiscount;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventBenefits {
    private final TotalDiscount totalDiscount;
    private final Gift gift;

    public EventBenefits(TotalDiscount totalDiscount, Gift gift) {
        this.totalDiscount = totalDiscount;
        this.gift = gift;
    }

    public static EventBenefits makeInitialConditionEventBenefits() {
        return new EventBenefits(makeInitialConditionTotalDiscount(), makeInitialConditionGift());
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
