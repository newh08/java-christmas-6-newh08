package christmas.model.domain.menu;

import static christmas.model.domain.menu.MenuCategory.DESSERT;
import static christmas.model.domain.menu.MenuCategory.MAIN;
import static christmas.model.domain.menu.MenuCategory.APPETIZER;
import static christmas.model.domain.menu.MenuCategory.BEVERAGE;
import static christmas.model.util.ErrorMessage.INVALID_ORDER_MESSAGE;

import christmas.model.util.MyIllegalArgumentException;
import java.util.Arrays;
import java.util.Objects;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),
    T_BONE_STAKE("티본스테이크", 55000, MAIN),
    BARBECUE_RIB("바비큐립", 54000, MAIN),
    SEE_FOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),
    CHOCO_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),
    ZERO_COKE("제로콜라", 3000, BEVERAGE),
    RED_WINE("레드와인", 60000, BEVERAGE),
    CHAMPAGNE("샴페인", 25000, BEVERAGE);

    private final String name;
    private final int price;
    private final MenuCategory category;

    Menu(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Menu getMenuByName(String menuName) {
        return Arrays.stream(values())
                .filter(menu -> menu.checkName(menuName))
                .findAny()
                .orElseThrow(() -> new MyIllegalArgumentException(INVALID_ORDER_MESSAGE));
    }

    public boolean checkName(String name) {
        return Objects.equals(this.name, name);
    }

    public boolean checkCategory(MenuCategory category) {
        return this.category.checkCategory(category);
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
