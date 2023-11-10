package christmas.model.service;

import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.dto.RequestOrderDto;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.RequestOrder;
import christmas.model.util.Converter;
import java.util.List;

public class OrderService {

    public OrderedMenusDto makeOrderMenusDto(List<RequestOrder> requestOrderList) {
        OrderedMenus orderedMenus = new OrderedMenus(requestOrderList);
        return Converter.from(orderedMenus);
    }

    public RequestOrder makeRequestOrder(RequestOrderDto requestOrderDto) {
        String menuName = requestOrderDto.getMenuName();
        int quantity = requestOrderDto.getQuantity();
        return new RequestOrder(menuName, quantity);
    }
}
