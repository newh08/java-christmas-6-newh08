package christmas.model.util;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.RequestOrdersDto;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.RequestOrder;
import christmas.model.domain.order.RequestOrders;
import christmas.model.domain.order.TotalOrderPrice;
import java.util.Map.Entry;

public class Converter {
    public DateDto from(final int inputDate) {
        return new DateDto(inputDate);
    }

    public RequestOrder from(final Entry<String, Integer> input) {
        String inputMenu = input.getKey();
        Integer inputQuantity = input.getValue();
        return new RequestOrder(inputMenu, inputQuantity);
    }

    public RequestOrdersDto from(final RequestOrders requestOrders) {
        String ordersMessage = requestOrders.makeOrdersMessage();
        TotalOrderPrice totalOrderPrice = requestOrders.getTotalOrderPrice();
        return new RequestOrdersDto(requestOrders.getRequestOrders(), ordersMessage, totalOrderPrice.getTotalOrderPrice());
    }

    public EventResultsDto from(final EventResults eventResults) {
        return new EventResultsDto(eventResults.getEventBenefit(), eventResults.getBadge());
    }

    public Date from(final DateDto dateDto) {
        return new Date(dateDto.getDate());
    }

    public RequestOrders from(RequestOrdersDto requestOrdersDto) {
        return new RequestOrders(requestOrdersDto.getRequestOrders());
    }
}
