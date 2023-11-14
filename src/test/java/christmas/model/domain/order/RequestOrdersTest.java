package christmas.model.domain.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.model.domain.menu.MenuCategory;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RequestOrdersTest {
    private RequestOrders requestOrders;

    // 테스트에 사용하기 위해 OrderedMenus 제공
    public static RequestOrders makeRequestOrdersWithTwoMainThreeDessertThreeAppetizer() {
        List<RequestOrder> requestOrderList = List.of(new RequestOrder("타파스", 3),
                new RequestOrder("바비큐립", 2),
                new RequestOrder("아이스크림", 3));

        return new RequestOrders(requestOrderList);
    }

    @BeforeEach
    void init() {
        RequestOrder requestOrder1 = new RequestOrder("레드와인", 4);
        RequestOrder requestOrder2 = new RequestOrder("제로콜라", 2);
        RequestOrder requestOrder3 = new RequestOrder("타파스", 5);
        requestOrders = new RequestOrders(List.of(requestOrder1, requestOrder2, requestOrder3));
    }

    @DisplayName("20개 초과로 주문하면 예외가 발생한다.")
    @Test
    void requestOrdersTest_1() {
        RequestOrder requestOrder = new RequestOrder("타파스", 21);
        List<RequestOrder> requestOrderList = List.of(requestOrder);

        assertThatThrownBy(() -> new RequestOrders(requestOrderList))
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("음료만 주문하면 예외가 발생한다.")
    @Test
    void requestOrdersTest_2() {
        RequestOrder requestOrder1 = new RequestOrder("레드와인", 4);
        RequestOrder requestOrder2 = new RequestOrder("제로콜라", 2);
        RequestOrder requestOrder3 = new RequestOrder("샴페인", 2);
        List<RequestOrder> requestOrderList = List.of(requestOrder1, requestOrder2, requestOrder3);

        assertThatThrownBy(() -> new RequestOrders(requestOrderList))
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("주문 메뉴와 수량으로 메시지가 생성된다.")
    @Test
    void requestOrdersTest_3() {
        assertThat(requestOrders.makeOrdersMessage()).isEqualTo("""
                레드와인 4개
                제로콜라 2개
                타파스 5개""");
    }

    @DisplayName("음료 총 6개를 주문하면 음료로 카테고리 검사시 6을 반환한다.")
    @Test
    void requestOrdersTest_4() {
        assertThat(requestOrders.getNumberOfSpecificCatalogOrder(MenuCategory.BEVERAGE)).isEqualTo(6);
    }

    @DisplayName("총 주문 금액을 반환한다.")
    @Test
    void requestOrderTest_5() {
        TotalOrderPrice totalOrderPrice = requestOrders.updatePrice();
        assertThat(totalOrderPrice.getTotalOrderPrice()).isEqualTo(273500);
    }

    @DisplayName("각 카테고리별 주문 수량을 반환한다.")
    @Test
    void requestOrdersTest_6() {

        int numberOfAppetizerOrder = requestOrders.getNumberOfSpecificCatalogOrder(MenuCategory.APPETIZER);
        int numberOfMainOrder = requestOrders.getNumberOfSpecificCatalogOrder(MenuCategory.MAIN);

        assertThat(numberOfAppetizerOrder).isEqualTo(5);
        assertThat(numberOfMainOrder).isEqualTo(0);

    }

}