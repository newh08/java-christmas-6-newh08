package christmas.model.domain.event.benefit;

import java.util.stream.Stream;

public class Gift {
    private static final int MINIMUM_GIFT_PRICE = 120000;
    private static final int GIFT_PRICE = -25000;
    private static final String GIFT_TRUE_MESSAGE = "샴페인 1개";
    private static final String GIFT_FALSE_MESSAGE = "없음";
    private static final String GIFT_BENEFIT_MESSAGE = "증정 이벤트: %,d원";

    private final boolean gift;

    public Gift(int totalPrice) {
        this.gift = totalPrice >= MINIMUM_GIFT_PRICE;
    }

    public static Gift makeInitialConditionGift() {
        return new Gift(0);
    }

    public int getGiftPrice() {
        if (gift) {
            return GIFT_PRICE;
        }
        return 0;
    }

    public String makeGiftMessage() {
        if (gift) {
            return GIFT_TRUE_MESSAGE;
        }
        return GIFT_FALSE_MESSAGE;
    }

    public Stream<String> makeGiftBenefitMessageStream() {
        if (gift) {
            return Stream.of(String.format(GIFT_BENEFIT_MESSAGE, GIFT_PRICE));
        }
        return Stream.empty();
    }
}
