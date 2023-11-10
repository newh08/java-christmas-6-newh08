package christmas.model.domain.event.discount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrder;
import christmas.model.domain.order.RequestOrders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountTest {

    private final Date specialDate = new Date(3);
    private final Date normalDate = new Date(14);
    private final Date weekendDate = new Date(9);
    private RequestOrders requestOrders;


    @BeforeEach
    void init() {
        requestOrders = new RequestOrders();
        requestOrders.addRequestOrder(new RequestOrder("아이스크림", 2));
        requestOrders.addRequestOrder(new RequestOrder("티본스테이크", 4));
    }

    @DisplayName("크리스마스 11일 전 이벤트 할인 금액을 계산하면 2300원이 나온다.")
    @Test
    void discountTest_Christmas() {
        Discount discount = new ChristmasDiscount();
        discount.calculateDiscountAmount(requestOrders, normalDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(2300);
    }
}