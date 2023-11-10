package christmas.model.domain.event;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.Discount;
import christmas.model.domain.event.discount.DiscountStrategy;
import christmas.model.domain.order.RequestOrders;
import java.util.List;

public class TotalDiscount {
    private final List<Discount> discounts;
    private int totalDiscount;

    public TotalDiscount() {
        discounts = DiscountStrategy.getAllDiscountStrategy();
        this.totalDiscount = 0;
    }

    public void applyDiscount(RequestOrders requestOrders, Date date) {
        discounts.stream()
                .peek(discount -> discount.calculateDiscountAmount(requestOrders, date))
                .map(Discount::getDiscountAmount)
                .forEach(discountAmount -> totalDiscount += discountAmount);
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }
}
