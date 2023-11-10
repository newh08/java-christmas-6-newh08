package christmas.model.domain.dto;

import christmas.model.domain.order.Price;
import christmas.model.domain.order.RequestOrder;
import java.util.List;
import java.util.stream.Collectors;

public class OrderedMenusDto {
    private final List<RequestOrder> requestOrders;
    private final Price price;

    public OrderedMenusDto(List<RequestOrder> requestOrders, Price price) {
        this.requestOrders = requestOrders;
        this.price = price;
    }

    public String getOrdersMessage() {
        return requestOrders.stream()
                .map(RequestOrder::toString)
                .collect(Collectors.joining("\n"));
    }

    public int getTotalPrice() {
        return price.getPrice();
    }
}
