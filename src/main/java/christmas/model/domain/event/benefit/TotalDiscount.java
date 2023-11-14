package christmas.model.domain.event.benefit;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrders;
import java.util.stream.Stream;

public interface TotalDiscount {

    void applyDiscount(RequestOrders requestOrders, Date date);

    Stream<String> makeDiscountBenefitMessageStream();

    int calculateDiscountBenefit();
}
