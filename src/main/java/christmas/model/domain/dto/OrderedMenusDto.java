package christmas.model.domain.dto;

import christmas.model.domain.order.TotalOrderPrice;
import christmas.model.domain.order.RequestOrder;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderedMenusDto {
    private final List<RequestOrder> requestOrders;
    private final TotalOrderPrice totalOrderPrice;

    public OrderedMenusDto(List<RequestOrder> requestOrders, TotalOrderPrice totalOrderPrice) {
        this.requestOrders = requestOrders;
        this.totalOrderPrice = totalOrderPrice;
    }

    public String getOrdersMessage() {
        return requestOrders.stream()
                .map(RequestOrder::toString)
                .collect(Collectors.joining("\n"));
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice.getTotalOrderPrice();
    }

    public List<RequestOrder> getRequestOrders() {
        return Collections.unmodifiableList(requestOrders);
    }
}
