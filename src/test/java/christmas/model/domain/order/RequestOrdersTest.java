package christmas.model.domain.order;

import christmas.model.domain.menu.MenuCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestOrdersTest {

    @DisplayName("각 카테고리별 주문 수량을 반환한다.")
    @Test
    void requestOrdersTest_1() {
        RequestOrders requestOrders = new RequestOrders();
        requestOrders.addRequestOrder(new RequestOrder("타파스", 3));
        requestOrders.addRequestOrder(new RequestOrder("바비큐립", 2));

        int numberOfAppetizerOrder = requestOrders.getNumberOfSpecificCatalogOrder(MenuCategory.APPETIZER);
        int numberOfMainOrder = requestOrders.getNumberOfSpecificCatalogOrder(MenuCategory.MAIN);

        Assertions.assertThat(numberOfAppetizerOrder).isEqualTo(3);
        Assertions.assertThat(numberOfMainOrder).isEqualTo(2);

    }

}