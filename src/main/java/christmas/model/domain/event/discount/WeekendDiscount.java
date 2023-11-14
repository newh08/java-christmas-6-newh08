package christmas.model.domain.event.discount;

import static christmas.model.domain.event.discount.WeekDiscount.WEEK_AND_WEEKEND_EVENT_DISCOUNT_AMOUNT;

import christmas.model.domain.date.Date;
import christmas.model.domain.menu.MenuCategory;
import christmas.model.domain.order.RequestOrders;

public class WeekendDiscount extends Discount {
    private static final String WEEKEND_DISCOUNT_MESSAGE = "주말 할인: %,d원";

    @Override
    public void calculateDiscountAmount(RequestOrders requestOrders, Date date) {
        if (date.isWeekEnd()) {
            int numberOfMainOrder = requestOrders.getNumberOfSpecificCatalogOrder(MenuCategory.MAIN);
            super.updateDiscountAmount(WEEK_AND_WEEKEND_EVENT_DISCOUNT_AMOUNT * numberOfMainOrder);
        }
    }

    @Override
    public void reset() {
        resetDiscount();
    }

    @Override
    public String toString() {
        return String.format(WEEKEND_DISCOUNT_MESSAGE, getDiscountAmount());
    }
}
