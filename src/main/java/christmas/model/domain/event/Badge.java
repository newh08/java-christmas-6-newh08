package christmas.model.domain.event;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {
    NONE(0), STAR(5000), TREE(10000), SANTA(20000);
    private final int minimumBenefitAmount;

    Badge(int minimumBenefitAmount) {
        this.minimumBenefitAmount = minimumBenefitAmount;
    }

    public static Badge getBadge(int totalBenefitAmount) {
        return Arrays.stream(values())
                .filter(badge -> badge.minimumBenefitAmount <= totalBenefitAmount)
                .max(Comparator.comparingInt(b -> b.minimumBenefitAmount))
                .orElse(NONE);
    }
}
