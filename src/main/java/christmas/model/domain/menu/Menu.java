package christmas.model.domain.menu;

public class Menu {
    private final MenuList menu;

    public Menu(MenuList menu) {
        this.menu = menu;
    }

    public boolean checkMenuNae(String name) {
        return menu.checkName(name);
    }
}
