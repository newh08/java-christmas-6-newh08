package christmas.model.domain.event.discount;

import static christmas.model.domain.order.RequestOrdersTest.makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.christmas.ChristmasWeekDiscount;
import christmas.model.domain.order.RequestOrders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekDiscountTest {

    @DisplayName("평일에 디져트 3개 주문으로 weekDiscount 계산하면 '평일 할인: -6,069원' 을 반환한다. ")
    @Test
    void weekDiscountTest_1() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(11);

        Discount discount = new ChristmasWeekDiscount();
        discount.calculateDiscountAmount(requestOrders, date);
        assertThat(discount.toString()).isEqualTo("평일 할인: -6,069원");
    }

    @DisplayName("주말에 디져트 3개 주문으로 weekDiscount 계산하면 할인은 0이다. ")
    @Test
    void weekDiscountTest_2() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(9);

        Discount discount = new ChristmasWeekDiscount();
        discount.calculateDiscountAmount(requestOrders, date);
        assertThat(discount.getDiscountAmount()).isEqualTo(0);
    }

}