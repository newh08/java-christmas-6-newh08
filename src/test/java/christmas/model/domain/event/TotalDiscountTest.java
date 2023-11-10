package christmas.model.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.domain.date.Date;
import christmas.model.domain.order.RequestOrder;
import christmas.model.domain.order.RequestOrders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalDiscountTest {

    @DisplayName("크리스마스 할인 3200 + 주말 메인 할인 10155 인 조건에서 할인을 적용하면 총 할인 금액이 13315 가 된다.")
    @Test
    void totalDiscountTest() {
        Date date = new Date(23);
        RequestOrders requestOrders = new RequestOrders();
        requestOrders.addRequestOrder(new RequestOrder("바비큐립", 2));
        requestOrders.addRequestOrder(new RequestOrder("티본스테이크", 3));
        requestOrders.addRequestOrder(new RequestOrder("초코케이크", 2));

        TotalDiscount totalDiscount = new TotalDiscount();
        totalDiscount.applyDiscount(requestOrders, date);
        assertThat(totalDiscount.getTotalDiscount()).isEqualTo(13315);
    }

}