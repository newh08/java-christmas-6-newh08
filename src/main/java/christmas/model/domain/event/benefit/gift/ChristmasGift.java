package christmas.model.domain.event.benefit.gift;

import christmas.model.domain.order.TotalOrderPrice;
import java.util.stream.Stream;

public class ChristmasGift implements Gift {
    private static final int MINIMUM_CHRISTMAS_GIFT_PRICE = 120000;
    private static final int CHRISTMAS_GIFT_PRICE = -25000;
    private static final String CHRISTMAS_GIFT_TRUE_MESSAGE = "샴페인 1개";
    private static final String CHRISTMAS_GIFT_FALSE_MESSAGE = "없음";
    private static final String CHRISTMAS_GIFT_BENEFIT_MESSAGE = "증정 이벤트: %,d원";

    private final boolean gift;

    private ChristmasGift(int totalPrice) {
        this.gift = totalPrice >= MINIMUM_CHRISTMAS_GIFT_PRICE;
    }

    public static Gift makeNoneGift() {
        return new ChristmasGift(0);
    }

    public static Gift makeChristmasGift(TotalOrderPrice totalOrderPrice) {
        return new ChristmasGift(totalOrderPrice.getTotalOrderPrice());
    }

    @Override
    public int getGiftBenefit() {
        if (gift) {
            return CHRISTMAS_GIFT_PRICE;
        }
        return 0;
    }

    @Override
    public String makeGiftMessage() {
        if (gift) {
            return CHRISTMAS_GIFT_TRUE_MESSAGE;
        }
        return CHRISTMAS_GIFT_FALSE_MESSAGE;
    }

    @Override
    public Stream<String> makeGiftBenefitMessageStream() {
        if (gift) {
            return Stream.of(String.format(CHRISTMAS_GIFT_BENEFIT_MESSAGE, CHRISTMAS_GIFT_PRICE));
        }
        return Stream.empty();
    }
}
