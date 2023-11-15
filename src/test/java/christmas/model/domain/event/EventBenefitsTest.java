package christmas.model.domain.event;

import static christmas.model.domain.order.RequestOrdersTest.makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.benefit.totaldiscount.ChristmasTotalDiscount;
import christmas.model.domain.event.benefit.EventBenefits;
import christmas.model.domain.event.strategy.ChristmasEventStrategy;
import christmas.model.domain.order.RequestOrders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitsTest {

    @DisplayName("주문 금액 12만원 이상 EventBenefits 을 만들면 giftMessage 로 샴페인이 나오고, 평일에 디저트 3개를 주문하면 혜택메시지로 '평일 할인: -6,069원' 을 가지고 있다.")
    @Test
    void test() {
        RequestOrders requestOrders = makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer();
        Date date = new Date(7);
        ChristmasEventStrategy christmasEventStrategy = new ChristmasEventStrategy(new ChristmasTotalDiscount());
        EventResults eventResults = christmasEventStrategy.updateEventResult(requestOrders, date);
        EventBenefits eventBenefits = eventResults.getEventBenefit();

        String giftMessage = eventBenefits.getGiftMessage();
        assertThat(giftMessage).isEqualTo("샴페인 1개");
        String benefitMessage = eventBenefits.makeBenefitMessage();
        assertThat(benefitMessage).contains("평일 할인: -6,069원");
    }

}