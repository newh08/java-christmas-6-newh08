package christmas.model.domain.menu;

public enum MenuCategory {
    APPETIZER, MAIN, DESSERT, BEVERAGE;

    public boolean checkCategory(MenuCategory checkingCategory) {
        return this.equals(checkingCategory);
    }
}
