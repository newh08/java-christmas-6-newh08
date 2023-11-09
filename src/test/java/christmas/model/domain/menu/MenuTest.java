package christmas.model.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {

    @DisplayName("MenuList 를 통해 Menu 를 만든 후, 동일한 이름으로 확인하면 True 를 반환한다.")
    @Test
    void menuTest_1() {
        Menu menu = new Menu(MenuList.BARBECUE_RIB);
        boolean result = menu.checkMenuNae("바비큐립");
        assertThat(result).isTrue();
    }

    @DisplayName("CHAMPAGNE 으로 Menu 를 만든 후 카테고리가 BEVERAGE 인지 확인하면 True 를 반환한다.")
    @Test
    void menuTest_2() {
        Menu menu = new Menu(MenuList.CHAMPAGNE);
        boolean result = menu.checkCategory(MenuCategory.BEVERAGE);
        assertThat(result).isTrue();
    }
}
