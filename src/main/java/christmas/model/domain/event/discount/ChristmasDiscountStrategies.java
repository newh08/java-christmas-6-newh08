package christmas.model.domain.event.discount;

import christmas.model.domain.event.discount.christmas.ChristmasDDayDiscount;
import christmas.model.domain.event.discount.christmas.ChristmasSpecialDiscount;
import christmas.model.domain.event.discount.christmas.ChristmasWeekDiscount;
import christmas.model.domain.event.discount.christmas.ChristmasWeekendDiscount;
import java.util.Arrays;
import java.util.List;

public enum ChristmasDiscountStrategies {
    DDAY(new ChristmasDDayDiscount()), WEEK(new ChristmasWeekDiscount()), WEEKEND(new ChristmasWeekendDiscount()), SPECIAL(new ChristmasSpecialDiscount());

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
