package christmas.model.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuCategoryTest {

    @DisplayName("MAIN 카테고리를 Main 인지 확인하면 True 를 반환하고, 다른 카테고리와 비교하면 False 가 나온다.")
    @Test
    void menuCategoryTest() {
        MenuCategory mainMenu = MenuCategory.MAIN;
        assertThat(mainMenu.checkCategory(MenuCategory.MAIN)).isTrue();
        assertThat(mainMenu.checkCategory(MenuCategory.APPETIZER)).isFalse();
    }
}