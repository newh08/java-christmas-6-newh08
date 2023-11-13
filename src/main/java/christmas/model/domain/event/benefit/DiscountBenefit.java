package christmas.model.domain.event.benefit;

public class DiscountBenefit {
    private final int discountBenefit;

    public DiscountBenefit(int discountBenefit) {
        this.discountBenefit = discountBenefit;
    }

    public int getDiscountBenefit() {
        return discountBenefit;
    }
}