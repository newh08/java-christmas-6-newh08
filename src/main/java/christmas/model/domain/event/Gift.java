package christmas.model.domain.event;

import christmas.model.domain.order.Price;

public class Gift {
    private static final int MINIMUM_GIFT_PRICE = 120000;
    private static final int GIFT_PRICE = 25000;
    private final boolean gift;

    public Gift(int totalPrice) {
        this.gift = totalPrice >= MINIMUM_GIFT_PRICE;
    }

    public int getGiftPrice() {
        if (gift) {
            return GIFT_PRICE;
        }
        return 0;
    }
}
