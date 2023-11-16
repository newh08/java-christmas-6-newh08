package christmas.model.domain.event.benefit;

import java.util.stream.Stream;

public class DiscountBenefit {

    private final int discountBenefit;
    private final Stream<String> discountMessageStream;

    public DiscountBenefit(int discountBenefit, Stream<String> discountMessageStream) {
        this.discountBenefit = discountBenefit;
        this.discountMessageStream = discountMessageStream;
    }

    public static DiscountBenefit makeZeroDiscountBenefit() {
        return new DiscountBenefit(0, Stream.empty());
    }

    public int getDiscountBenefit() {
        return discountBenefit;
    }

    public Stream<String> getDiscountMessage() {
        return discountMessageStream;
    }
}

