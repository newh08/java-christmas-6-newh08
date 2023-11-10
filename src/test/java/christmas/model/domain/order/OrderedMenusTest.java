package christmas.model.domain.order;

import christmas.model.domain.menu.MenuCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderedMenusTest {

    @DisplayName("각 카테고리별 주문 수량을 반환한다.")
    @Test
    void requestOrdersTest_1() {
        OrderedMenus orderedMenus = new OrderedMenus();
        orderedMenus.addRequestOrder(new RequestOrder("타파스", 3));
        orderedMenus.addRequestOrder(new RequestOrder("바비큐립", 2));

        int numberOfAppetizerOrder = orderedMenus.getNumberOfSpecificCatalogOrder(MenuCategory.APPETIZER);
        int numberOfMainOrder = orderedMenus.getNumberOfSpecificCatalogOrder(MenuCategory.MAIN);

        Assertions.assertThat(numberOfAppetizerOrder).isEqualTo(3);
        Assertions.assertThat(numberOfMainOrder).isEqualTo(2);

    }

}