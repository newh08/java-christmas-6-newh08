package christmas.model.domain.event.discount;

import java.util.Arrays;
import java.util.List;

public enum ChristmasDiscountStrategies {
    CHRISTMAS(new ChristmasDiscount()), WEEK(new WeekDiscount()), WEEKEND(new WeekendDiscount()), SPECIAL(new SpecialDiscount());

    private final Discount discount;

    ChristmasDiscountStrategies(Discount discount) {
        this.discount = discount;
    }

    public static List<Discount> getAllDiscountStrategy() {
        return Arrays.stream(values())
                .map(discountStrategy -> discountStrategy.discount)
                .peek(Discount::reset)
                .toList();
    }
}
