package christmas.model.domain.event.discount.christmas;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.Discount;
import christmas.model.domain.order.RequestOrders;

public class ChristmasDDayDiscount extends Discount {
    private static final int BASIC_DISCOUNT_AMOUNT = 1000;
    private static final int ADDITIONAL_DISCOUNT_AMOUNT_PER_DAY = 100;
    private static final int NUMBER_TO_COUNT_DISCOUNT_DAY = 24;
    private static final String CHRISTMAS_DISCOUNT_MESSAGE = "크리스마스 디데이 할인: %,d원";

    @Override
    public void calculateDiscountAmount(RequestOrders requestOrders, Date date) {
        if (date.isAfterChristmas()) {
            return;
        }
        int dDayFromChristmas = date.getDDayFromChristmas();
        super.updateDiscountAmount(BASIC_DISCOUNT_AMOUNT + calculateToCountDiscountDay(dDayFromChristmas) * ADDITIONAL_DISCOUNT_AMOUNT_PER_DAY);
    }

    @Override
    public String toString() {
        return String.format(CHRISTMAS_DISCOUNT_MESSAGE, getDiscountAmount());
    }

    @Override
    protected void reset() {
        resetDiscount();
    }

    private int calculateToCountDiscountDay(int dDayFromChristmas) {
        return NUMBER_TO_COUNT_DISCOUNT_DAY - dDayFromChristmas;
    }
}
