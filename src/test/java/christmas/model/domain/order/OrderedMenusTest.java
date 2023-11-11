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

    @DisplayName("20개 초과로 주문하면 예외가 발생한다.")
    @Test
    void requestOrderTest_2() {
        RequestOrder requestOrder = new RequestOrder("타파스", 21);
        List<RequestOrder> requestOrders = List.of(requestOrder);
        Assertions.assertThatThrownBy(() -> new OrderedMenus(requestOrders))
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void requestOrderTest_3() {
        RequestOrder requestOrder1 = new RequestOrder("레드와인", 4);
        RequestOrder requestOrder2 = new RequestOrder("제로콜라", 2);
        RequestOrder requestOrder3 = new RequestOrder("샴페인", 2);
        List<RequestOrder> requestOrders = List.of(requestOrder1, requestOrder2, requestOrder3);

        Assertions.assertThatThrownBy(() -> new OrderedMenus(requestOrders))
                .hasMessageContaining("[ERROR]");
    }
}