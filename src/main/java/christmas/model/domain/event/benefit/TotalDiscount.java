package christmas.model.domain.event.benefit;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.Discount;
import christmas.model.domain.event.discount.DiscountStrategy;
import christmas.model.domain.order.RequestOrders;
import java.util.List;
import java.util.stream.Stream;

public class TotalDiscount {
    private final List<Discount> discounts;

    public TotalDiscount() {
        discounts = DiscountStrategy.getAllDiscountStrategy();
    }

    public static TotalDiscount makeInitialConditionTotalDiscount() {
        return new TotalDiscount();
    }

    public void applyDiscount(RequestOrders requestOrders, Date date) {
        discounts.forEach(discount -> discount.calculateDiscountAmount(requestOrders, date));
    }

    public int calculateDiscountBenefit() {
        return discounts.stream()
                .mapToInt(Discount::getDiscountAmount)
                .sum();
    }

    public Stream<String> makeDiscountBenefitMessageStream() {
        return discounts.stream()
                .filter(Discount::isNotZero)
                .map(Discount::toString);
    }
}
