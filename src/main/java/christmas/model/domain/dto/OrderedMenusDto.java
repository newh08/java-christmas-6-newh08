package christmas.model.domain.dto;

import christmas.model.domain.order.RequestOrders;
import christmas.model.domain.order.TotalOrderPrice;

public class OrderedMenusDto {
    private final RequestOrders requestOrders;
    private final TotalOrderPrice totalOrderPrice;

    public OrderedMenusDto(RequestOrders requestOrders, TotalOrderPrice totalOrderPrice) {
        this.requestOrders = requestOrders;
        this.totalOrderPrice = totalOrderPrice;
    }

    public String getOrdersMessage() {
        return requestOrders.makeOrdersMessage();
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice.getTotalOrderPrice();
    }

    public RequestOrders getRequestOrders() { return requestOrders; }
}
