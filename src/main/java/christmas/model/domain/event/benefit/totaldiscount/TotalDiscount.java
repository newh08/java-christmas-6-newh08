package christmas.model.domain.event.benefit.totaldiscount;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.DiscountBenefit;
import christmas.model.domain.order.RequestOrders;
import java.util.stream.Stream;

public interface TotalDiscount {

    void applyDiscount(RequestOrders requestOrders, Date date);

    Stream<String> makeDiscountBenefitMessageStream();

    int calculateDiscountBenefit();

    DiscountBenefit makeDiscountBenefit();
}
