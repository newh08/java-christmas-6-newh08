package christmas.model.domain.event;

import static christmas.model.domain.event.benefit.ChristmasTotalDiscount.makeInitialConditionTotalDiscount;
import static christmas.model.domain.order.RequestOrdersTest.makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.ChristmasTotalDiscount;
import christmas.model.domain.order.RequestOrders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasTotalDiscountTest {

    @DisplayName("크리스마스 할인 3200 + 주말 메인 할인 4046 인 조건에서 할인을 적용하면 총 할인 금액이 -7246 가 된다.")
    @Test
    void totalDiscountTest() {
        Date date = new Date(23);
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();

        ChristmasTotalDiscount christmasTotalDiscount = makeInitialConditionTotalDiscount();
        christmasTotalDiscount.applyDiscount(requestOrders, date);
        assertThat(christmasTotalDiscount.calculateDiscountBenefit()).isEqualTo(-7246);
    }

}