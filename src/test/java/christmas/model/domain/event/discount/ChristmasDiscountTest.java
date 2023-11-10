package christmas.model.domain.event.discount;

import static christmas.model.domain.order.OrderedMenusTest.makeOrderedMenusWithTwoMainThreeDessertThreeAppetizer;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.OrderedMenus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDiscountTest {

    @DisplayName("3일 가지고 discount 를 계산 하면 출력값으로 '크리스마스 디데이 할인: -1,200원' 을 반환한다.")
    @Test
    void christmasDiscountTest() {
        OrderedMenus orderedMenus = makeOrderedMenusWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(3);

        ChristmasDiscount christmasDiscount = new ChristmasDiscount();
        christmasDiscount.calculateDiscountAmount(orderedMenus, date);
        Assertions.assertThat(christmasDiscount.toString()).isEqualTo("크리스마스 디데이 할인: -1,200원");
    }

}