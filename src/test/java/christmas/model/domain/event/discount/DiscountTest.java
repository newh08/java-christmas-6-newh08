package christmas.model.domain.event.discount;

import static christmas.model.domain.order.RequestOrdersTest.makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.christmas.ChristmasDDayDiscount;
import christmas.model.domain.event.discount.christmas.ChristmasSpecialDiscount;
import christmas.model.domain.event.discount.christmas.ChristmasWeekDiscount;
import christmas.model.domain.event.discount.christmas.ChristmasWeekendDiscount;
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
        requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
    }

    @DisplayName("크리스마스 11일 전 이벤트 할인 금액을 계산하면 -2300원이 나온다.")
    @Test
    void discountTest_Christmas() {
        Discount discount = new ChristmasDDayDiscount();
        discount.calculateDiscountAmount(requestOrders, normalDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(-2300);
    }

    @DisplayName("SpecialDay 로 이벤트 할인 금액을 계산하면 -1000원이 나온다.")
    @Test
    void discountTest_Special() {
        Discount discount = new ChristmasSpecialDiscount();
        discount.calculateDiscountAmount(requestOrders, specialDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(-1000);
    }

    @DisplayName("평일에 디져트 3개를 주문으로 할일 금액을 계산하면 -6069 가 나온다.")
    @Test
    void discountTest_Week() {
        Discount discount = new ChristmasWeekDiscount();
        discount.calculateDiscountAmount(requestOrders, normalDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(-6069);
    }

    @DisplayName("주말에 메인 2개를 주문으로 할일 금액을 계산하면 -4046 이 나온다.")
    @Test
    void discountTest_Weekend() {
        Discount discount = new ChristmasWeekendDiscount();
        discount.calculateDiscountAmount(requestOrders, weekendDate);

        assertThat(discount.getDiscountAmount()).isEqualTo(-4046);
    }
}