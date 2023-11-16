package christmas.model.domain.dto;

import christmas.model.domain.order.RequestOrder;
import java.util.Collections;
import java.util.List;

public class RequestOrdersDto {

    private final List<RequestOrder> requestOrders;
    private final String ordersMessage;
    private final int totalOrderPrice;

    public RequestOrdersDto(List<RequestOrder> requestOrders, String ordersMessage, int totalOrderPrice) {
        this.requestOrders = requestOrders;
        this.ordersMessage = ordersMessage;
        this.totalOrderPrice = totalOrderPrice;
    }

    public List<RequestOrder> getRequestOrders() {
        return Collections.unmodifiableList(requestOrders);
    }

    public String getOrdersMessage() {
        return ordersMessage;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
