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

    @DisplayName("SpecialDay 로 이벤트 할인 금액을 계산하면 1000원이 나온다.")
    @Test
    void discountTest_Special() {
        Discount discount = new SpecialDiscount();
        discount.calculateDiscountAmount(requestOrders, specialDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(1000);
    }

    @DisplayName("평일에 디져트 2개를 주문으로 할일 금액을 계산하면 4046 이 나온다.")
    @Test
    void discountTest_Week() {
        Discount discount = new WeekDiscount();
        discount.calculateDiscountAmount(requestOrders, normalDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(4046);
    }

    @DisplayName("주말에 메인 4개를 주문으로 할일 금액을 계산하면 8092 가 나온다.")
    @Test
    void discountTest_Weekend() {
        Discount discount = new WeekendDiscount();
        discount.calculateDiscountAmount(requestOrders, weekendDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(8092);
    }
}