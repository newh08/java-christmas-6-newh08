package christmas.model.domain.event;

import christmas.model.domain.event.benefit.Gift;
import christmas.model.domain.order.TotalOrderPrice;
import christmas.model.domain.order.RequestOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiftTest {

    @DisplayName("12만원 이상의 Price 로 Gift 생성 후 선물 금액을 확인하면 -25000이 나온다.")
    @Test
    void giftTest() {
        TotalOrderPrice totalOrderPrice = new TotalOrderPrice();
        RequestOrder requestOrder = new RequestOrder("바비큐립", 3);
        totalOrderPrice.updateTotalOrderPrice(requestOrder);

        Gift gift = totalOrderPrice.makeGiftPerTotalOrderPrice();
        Assertions.assertThat(gift.getGiftPrice()).isEqualTo(-25000);
    }

}