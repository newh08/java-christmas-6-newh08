package christmas.model.domain.event.discount;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;

public class SpecialDiscount extends Discount{
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private static final String SPECIAL_DISCOUNT_MESSAGE = "특별 할인: %,d원";

    @Override
    public void calculateDiscountAmount(OrderedMenus orderedMenus, Date date) {
        if (date.isSpecialDate()) {
            super.updateDiscountAmount(SPECIAL_DISCOUNT_AMOUNT);
        }
    }

    @Override
    public String toString() {
        return String.format(SPECIAL_DISCOUNT_MESSAGE, getDiscountAmount());
    }
}
