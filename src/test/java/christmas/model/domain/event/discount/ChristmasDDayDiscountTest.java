package christmas.model.domain.event.discount;

import static christmas.model.domain.order.RequestOrdersTest.makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.discount.christmas.ChristmasDDayDiscount;
import christmas.model.domain.order.RequestOrders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDDayDiscountTest {

    @DisplayName("3일 가지고 discount 를 계산 하면 출력값으로 '크리스마스 디데이 할인: -1,200원' 을 반환한다.")
    @Test
    void christmasDiscountTest() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(3);

        ChristmasDDayDiscount christmasDDayDiscount = new ChristmasDDayDiscount();
        christmasDDayDiscount.calculateDiscountAmount(requestOrders, date);
        assertThat(christmasDDayDiscount.toString()).isEqualTo("크리스마스 디데이 할인: -1,200원");
    }

    @DisplayName("26일 가지고 discount 를 계산 하면 할인은 없다.")
    @Test
    void christmasDiscountTest_2() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(26);

        ChristmasDDayDiscount christmasDDayDiscount = new ChristmasDDayDiscount();
        christmasDDayDiscount.calculateDiscountAmount(requestOrders, date);
        assertThat(christmasDDayDiscount.toString()).isEqualTo("크리스마스 디데이 할인: 0원");
    }

}