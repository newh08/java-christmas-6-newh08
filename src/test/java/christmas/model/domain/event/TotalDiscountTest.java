package christmas.model.domain.event;

import static christmas.model.domain.order.OrderedMenusTest.makeOrderedMenusWithTwoMainThreeDessertThreeAppetizer;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.TotalDiscount;
import christmas.model.domain.order.OrderedMenus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalDiscountTest {

    @DisplayName("크리스마스 할인 3200 + 주말 메인 할인 4046 인 조건에서 할인을 적용하면 총 할인 금액이 -7246 가 된다.")
    @Test
    void totalDiscountTest() {
        Date date = new Date(23);
        OrderedMenus orderedMenus = makeOrderedMenusWithTwoMainThreeDessertThreeAppetizer();

        TotalDiscount totalDiscount = new TotalDiscount();
        totalDiscount.applyDiscount(orderedMenus, date);
        assertThat(totalDiscount.getTotalDiscount()).isEqualTo(-7246);
    }

}