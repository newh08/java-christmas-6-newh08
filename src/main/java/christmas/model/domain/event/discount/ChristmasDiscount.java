package christmas.model.domain.event.discount;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;

public class ChristmasDiscount extends Discount{
    private static final int BASIC_DISCOUNT_AMOUNT = 1000;
    private static final int ADDITIONAL_DISCOUNT_AMOUNT_PER_DAY = 100;
    private static final int NUMBER_TO_COUNT_DISCOUNT_DAY = 24;

    @Override
    public void calculateDiscountAmount(OrderedMenus orderedMenus, Date date) {
        int dDayFromChristmas = date.getDDayFromChristmas();
        if (dDayFromChristmas < 0) {
            return;
        }
        super.updateDiscountAmount(BASIC_DISCOUNT_AMOUNT + calculateToCountDiscountDay(dDayFromChristmas) * ADDITIONAL_DISCOUNT_AMOUNT_PER_DAY);
    }

    private int calculateToCountDiscountDay(int dDayFromChristmas) {
        return NUMBER_TO_COUNT_DISCOUNT_DAY - dDayFromChristmas;
    }
}
