package christmas.model.domain.event.discount;

import static christmas.model.domain.order.RequestOrdersTest.makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrders;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountTest {

    @DisplayName("SpecialDate 에 SpecialDiscount 계산 하면 출력값으로 '특별할인: -1,000원' 을 반환한다.")
    @Test
    void specialDiscountTest_1() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(10);

        Discount discount = new SpecialDiscount();
        discount.calculateDiscountAmount(requestOrders, date);
        Assertions.assertThat(discount.toString()).isEqualTo("특별 할인: -1,000원");
    }

    @DisplayName("SpecialDate 가 아닌 날에 SpecialDiscount 계산 하면 할인은 0이다.")
    @Test
    void specialDiscountTest_2() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(13);

        Discount discount = new SpecialDiscount();
        discount.calculateDiscountAmount(requestOrders, date);
        Assertions.assertThat(discount.getDiscountAmount()).isEqualTo(0);
    }

}