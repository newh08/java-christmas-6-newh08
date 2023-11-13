package christmas.model.domain.event.benefit;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.Discount;
import christmas.model.domain.event.discount.DiscountStrategy;
import christmas.model.domain.order.OrderedMenus;
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

    public DiscountBenefit applyDiscount(OrderedMenus orderedMenus, Date date) {
        int discountBenefit = discounts.stream()
                .peek(discount -> discount.calculateDiscountAmount(orderedMenus, date))
                .mapToInt(Discount::getDiscountAmount)
                .sum();
        return new DiscountBenefit(discountBenefit);
    }

    public Stream<String> makeDiscountBenefitMessageStream() {
        return discounts.stream()
                .filter(Discount::isNotZero)
                .map(Discount::toString);
    }
}
