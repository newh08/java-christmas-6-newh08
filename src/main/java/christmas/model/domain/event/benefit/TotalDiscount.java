package christmas.model.domain.event.benefit;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.Discount;
import christmas.model.domain.event.discount.DiscountStrategy;
import christmas.model.domain.order.OrderedMenus;
import java.util.List;
import java.util.stream.Stream;

public class TotalDiscount {
    private final List<Discount> discounts;
    private int totalDiscount;

    public TotalDiscount() {
        discounts = DiscountStrategy.getAllDiscountStrategy();
        this.totalDiscount = 0;
    }

    public void applyDiscount(OrderedMenus orderedMenus, Date date) {
        discounts.stream()
                .peek(discount -> discount.calculateDiscountAmount(orderedMenus, date))
                .map(Discount::getDiscountAmount)
                .forEach(discountAmount -> totalDiscount += discountAmount);
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public Stream<String> makeMessageStream() {
        return discounts.stream()
                .filter(Discount::isNotZero)
                .map(Discount::toString);
    }
}
