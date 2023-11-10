package christmas.model.domain.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalOrderPriceTest {

    @DisplayName("54,000 원인 바비큐립 2개를 주문 후 Price 에 업데이트 하면 Price 안의 가격이 108000 이 된다.")
    @Test
    void priceTest_1() {
        TotalOrderPrice totalOrderPrice = new TotalOrderPrice();
        RequestOrder requestOrder = new RequestOrder("바비큐립", 2);
        totalOrderPrice.updateTotalOrderPrice(requestOrder);
        Assertions.assertThat(totalOrderPrice.getTotalOrderPrice()).isEqualTo(108000);
    }
}