package christmas.model.domain.event.discount;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;

public abstract class Discount {
    private int discountAmount;

    public abstract void calculateDiscountAmount(OrderedMenus orderedMenus, Date date);

    public abstract String toString();

    public abstract void reset();

    void updateDiscountAmount(int discountAmount) {
        this.discountAmount -= discountAmount;
    }

    public boolean isNotZero() {
        return discountAmount != 0;
    }

    public void resetDiscount() {
        discountAmount = 0;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
