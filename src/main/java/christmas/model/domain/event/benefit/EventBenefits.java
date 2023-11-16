package christmas.model.domain.event.benefit;

import static christmas.model.domain.event.benefit.DiscountBenefit.makeZeroDiscountBenefit;
import static christmas.model.domain.event.benefit.gift.ChristmasGift.makeNoneGift;

import christmas.model.domain.event.benefit.gift.Gift;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventBenefits {
    private final DiscountBenefit discountBenefit;
    private final Gift gift;

    public EventBenefits(DiscountBenefit discountBenefit, Gift gift) {
        this.discountBenefit = discountBenefit;
        this.gift = gift;
    }

    public static EventBenefits makeZeroEventBenefits() {
        return new EventBenefits(makeZeroDiscountBenefit(), makeNoneGift());
    }

    public String makeBenefitMessage() {
        Stream<String> discountBenefitMessage = discountBenefit.getDiscountMessage();
        Stream<String> giftBenefitMessage = gift.makeGiftBenefitMessageStream();
        return Stream.concat(discountBenefitMessage, giftBenefitMessage)
                .collect(Collectors.joining("\n"));
    }

    public String getGiftMessage() {
        return gift.makeGiftMessage();
    }

    public int getDiscountBenefit() {
        return discountBenefit.getDiscountBenefit();
    }

    public int getTotalBenefit() {
        return discountBenefit.getDiscountBenefit() + gift.getGiftBenefit();
    }

}
