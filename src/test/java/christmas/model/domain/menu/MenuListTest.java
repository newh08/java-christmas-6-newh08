package christmas.model.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuListTest {

    @DisplayName("MenuList 에서 모든 메뉴로 리스트를 만들어 반환하며 해당 리스트를 수정하려 하면 UnsupportedOperationException 이 발생한다.")
    @Test
    void menuListTest_1() {
        List<Menu> menus = MenuList.makeUnmodifiableMenus();
        assertThat(menus.size()).isEqualTo(12);
        assertThatThrownBy(() -> menus.add(new Menu(MenuList.CHAMPAGNE)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("MenuList 에 없는 메뉴 이름을 확인하면 False 를, 있는 이름을 확인하면 True 를 반환한다.")
    @Test
    void menuListTest_2() {
        assertThat(MenuList.containName("스테이크")).isFalse();
        assertThat(MenuList.containName("티본스테이크")).isTrue();
    }
}