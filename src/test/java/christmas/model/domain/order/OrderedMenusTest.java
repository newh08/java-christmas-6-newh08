package christmas.model.domain.order;

import christmas.model.domain.menu.MenuCategory;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderedMenusTest {

    // 테스트에 사용하기 위해 OrderedMenus 제공
    public static OrderedMenus makeOrderedMenusWithTwoMainThreeDessertThreeAppetizer() {
        List<RequestOrder> requestOrders = List.of(new RequestOrder("타파스", 3),
                new RequestOrder("바비큐립", 2),
                new RequestOrder("아이스크림", 3));

        return new OrderedMenus(requestOrders);
    }

    @DisplayName("각 카테고리별 주문 수량을 반환한다.")
    @Test
    void requestOrdersTest_1() {
        OrderedMenus orderedMenus = makeOrderedMenusWithTwoMainThreeDessertThreeAppetizer();

        int numberOfAppetizerOrder = orderedMenus.getNumberOfSpecificCatalogOrder(MenuCategory.APPETIZER);
        int numberOfMainOrder = orderedMenus.getNumberOfSpecificCatalogOrder(MenuCategory.MAIN);

        Assertions.assertThat(numberOfAppetizerOrder).isEqualTo(3);
        Assertions.assertThat(numberOfMainOrder).isEqualTo(2);

    }

}