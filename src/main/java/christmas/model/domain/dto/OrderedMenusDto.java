package christmas.model.domain.dto;

import christmas.model.domain.order.Price;
import christmas.model.domain.order.RequestOrder;
import java.util.List;

public class OrderedMenusDto {
    private final List<RequestOrder> requestOrders;
    private final Price price;

    public OrderedMenusDto(List<RequestOrder> requestOrders, Price price) {
        this.requestOrders = requestOrders;
        this.price = price;
    }

    public List<RequestOrder> getRequestOrders() {
        return requestOrders;
    }

    public Price getPrice() {
        return price;
    }
}
