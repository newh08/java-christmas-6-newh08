package christmas.model.domain.menu;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @DisplayName("양송이수프 로 메뉴를 가져오면 MUSHROOM_SOUP 를 가져오며 메뉴에 없는 이름은 예외를 발생시킨다.")
    @Test
    void ManuListTest() {
        Menu menu = Menu.getMenuByName("양송이수프");
        Assertions.assertThat(menu).isEqualTo(Menu.MUSHROOM_SOUP);
        Assertions.assertThatThrownBy(() -> Menu.getMenuByName("양송이")).hasMessageContaining("[ERROR]");
    }

}