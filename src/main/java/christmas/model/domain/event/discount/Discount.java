package christmas.model.domain.event.discount;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrders;

public abstract class Discount {
    private int discountAmount;

    public abstract void calculateDiscountAmount(RequestOrders requestOrders, Date date);

    void updateDiscountAmount(int discountAmount) {
        this.discountAmount += discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

}
