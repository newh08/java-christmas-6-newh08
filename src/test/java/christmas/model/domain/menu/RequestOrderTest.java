package christmas.model.domain.menu;

import christmas.model.domain.order.RequestOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RequestOrderTest {

    @DisplayName("메뉴에 없는 이름으로 RequestOrder 를 생성하면 오류가 발생한다.")
    @Test
    void RequestOrderValidationTest() {
        Assertions.assertThatThrownBy(() -> new RequestOrder("스테이크", 1)).hasMessageContaining("[ERROR]");
    }

}