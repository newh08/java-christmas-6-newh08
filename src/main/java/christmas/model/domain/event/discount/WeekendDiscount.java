package christmas.model.domain.event.discount;

import static christmas.model.domain.event.discount.WeekDiscount.WEEK_AND_WEEKEND_EVENT_DISCOUNT_AMOUNT;

import christmas.model.domain.date.Date;
import christmas.model.domain.menu.MenuCategory;
import christmas.model.domain.order.OrderedMenus;

public class WeekendDiscount extends Discount {

    @Override
    public void calculateDiscountAmount(OrderedMenus orderedMenus, Date date) {
        if (date.isWeekEnd()) {
            int numberOfMainOrder = orderedMenus.getNumberOfSpecificCatalogOrder(MenuCategory.MAIN);
            super.updateDiscountAmount(WEEK_AND_WEEKEND_EVENT_DISCOUNT_AMOUNT * numberOfMainOrder);
        }
    }
}
