package christmas.model.domain.event.discount.christmas;

import static christmas.model.domain.menu.MenuCategory.DESSERT;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.Discount;
import christmas.model.domain.order.RequestOrders;

public class ChristmasWeekDiscount extends Discount {
    static final int WEEK_AND_WEEKEND_EVENT_DISCOUNT_AMOUNT = 2023;
    private static final String SPECIAL_DISCOUNT_MESSAGE = "평일 할인: %,d원";

    @Override
    public void calculateDiscountAmount(RequestOrders requestOrders, Date date) {
        if (date.isWeekEnd()) {
            return;
        }
        int numberOfDessertOrder = requestOrders.getNumberOfSpecificCatalogOrder(DESSERT);
        super.updateDiscountAmount(WEEK_AND_WEEKEND_EVENT_DISCOUNT_AMOUNT * numberOfDessertOrder);
    }

    @Override
    protected void reset() {
        resetDiscount();
    }

    @Override
    public String toString() {
        return String.format(SPECIAL_DISCOUNT_MESSAGE, getDiscountAmount());
    }
}
