package christmas.model.domain.event.discount;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;

public abstract class Discount {
    private int discountAmount;

    public abstract void calculateDiscountAmount(OrderedMenus orderedMenus, Date date);

    void updateDiscountAmount(int discountAmount) {
        this.discountAmount += discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

}
