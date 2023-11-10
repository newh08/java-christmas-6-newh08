package christmas.model.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.event.benefit.TotalDiscount;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.OrderedMenusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitsTest {

    @DisplayName("주문 금액 12만원 이하로 EventBenefits 을 만들면 giftMessage 는 없고, 평일에 디저트 3개를 주문하면 혜택메시지로 '평일 할인: -6,069원' 을 가지고 있다.")
    @Test
    void test() {
        EventBenefits eventBenefits = new EventBenefits(new TotalDiscount(), new Gift(0));
        OrderedMenus orderedMenus = OrderedMenusTest.makeOrderedMenusWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(7);
        eventBenefits.applyDiscount(orderedMenus, date);

        String giftMessage = eventBenefits.getGiftMessage();
        assertThat(giftMessage).isEqualTo("없음");
        String benefitMessage = eventBenefits.makeBenefitMessage();
        assertThat(benefitMessage).contains("평일 할인: -6,069원");
    }

}