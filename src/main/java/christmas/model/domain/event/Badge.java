package christmas.model.domain.event;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {
    NONE(0, "없음"), STAR(5000, "별"), TREE(10000, "트리"), SANTA(20000, "산타");
    private final int minimumBenefitAmount;
    private final String name;

    Badge(int minimumBenefitAmount, String name) {
        this.minimumBenefitAmount = minimumBenefitAmount;
        this.name = name;
    }

    public static Badge getBadge(int totalBenefitAmount) {
        return Arrays.stream(values())
                .filter(badge -> badge.minimumBenefitAmount <= totalBenefitAmount)
                .max(Comparator.comparingInt(b -> b.minimumBenefitAmount))
                .orElse(NONE);
    }

    @Override
    public String toString() {
        return name;
    }
}
