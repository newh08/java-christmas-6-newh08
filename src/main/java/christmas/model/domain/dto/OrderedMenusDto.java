package christmas.model.domain.dto;

import christmas.model.domain.order.RequestOrders;

public class OrderedMenusDto {
    private final RequestOrders requestOrders;

    public OrderedMenusDto(RequestOrders requestOrders) {
        this.requestOrders = requestOrders;
    }

    public String getOrdersMessage() {
        return requestOrders.makeOrdersMessage();
    }

    public int getTotalOrderPrice() {
        return requestOrders.getTotalOrderPrice().getTotalOrderPrice();
    }

    public RequestOrders getRequestOrders() { return requestOrders; }
}
