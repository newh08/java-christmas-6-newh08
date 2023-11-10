package christmas.model.service;

import christmas.model.domain.dto.RequestOrderDto;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.RequestOrder;
import java.util.List;

public class OrderService {

    public OrderedMenus makeOrderMenus(List<RequestOrder> requestOrderList) {
        OrderedMenus orderedMenus = new OrderedMenus();
        for (RequestOrder requestOrder : requestOrderList) {
            orderedMenus.addRequestOrder(requestOrder);
        }
        return orderedMenus;
    }

    public RequestOrder makeRequestOrder(RequestOrderDto requestOrderDto) {
        String menuName = requestOrderDto.getMenuName();
        int quantity = requestOrderDto.getQuantity();
        return new RequestOrder(menuName, quantity);
    }
}
