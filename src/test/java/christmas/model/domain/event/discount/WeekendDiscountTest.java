package christmas.model.domain.event.discount;

import static christmas.model.domain.order.RequestOrdersTest.makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.christmas.ChristmasWeekendDiscount;
import christmas.model.domain.order.RequestOrders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendDiscountTest {

    @DisplayName("주말에 메인 2개 주문으로 weekDiscount 계산하면 '주말 할인: -4,046원' 을 반환한다. ")
    @Test
    void weekendDiscountTest_1() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(9);

        Discount discount = new ChristmasWeekendDiscount();
        discount.calculateDiscountAmount(requestOrders, date);
        assertThat(discount.toString()).isEqualTo("주말 할인: -4,046원");
    }

    @DisplayName("평일에 메인 3개 주문으로 weekDiscount 계산하면 할인은 0이다. ")
    @Test
    void weekendDiscountTest_2() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();

        Date date = new Date(11);

        Discount discount = new ChristmasWeekendDiscount();
        discount.calculateDiscountAmount(requestOrders, date);
        assertThat(discount.getDiscountAmount()).isEqualTo(0);
    }

}