package christmas.model.domain.event.discount;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrders;

public class SpecialDiscount extends Discount{
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;

    @Override
    public void calculateDiscountAmount(RequestOrders requestOrders, Date date) {
        if (date.isSpecialDate()) {
            super.updateDiscountAmount(SPECIAL_DISCOUNT_AMOUNT);
        }
    }
}
