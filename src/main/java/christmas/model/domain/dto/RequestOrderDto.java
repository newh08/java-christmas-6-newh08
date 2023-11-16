package christmas.model.domain.dto;

public class RequestOrderDto {
    private final String menuName;
    private final int quantity;

    public RequestOrderDto(String menuName, int quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }
}
