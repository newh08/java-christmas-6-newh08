package christmas.model.util;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.RequestOrder;
import java.util.Map.Entry;

public class Converter {
    public EventResultsDto from(final EventResults eventResults) {
        return new EventResultsDto(eventResults.getEventBenefit(), eventResults.getTotalBenefitAmount(),
                eventResults.getBadge());
    }

    public OrderedMenusDto from(final OrderedMenus orderedMenus) {
        return new OrderedMenusDto(orderedMenus.getRequestOrders(), orderedMenus.getTotalOrderPrice());
    }

    public DateDto from(final int inputDate) {
        return new DateDto(inputDate);
    }

    public RequestOrder from(Entry<String, Integer> input) {
        String inputMenu = input.getKey();
        Integer inputQuantity = input.getValue();
        return new RequestOrder(inputMenu, inputQuantity);
    }

    public OrderedMenus from(OrderedMenusDto orderedMenusDto) {
        return new OrderedMenus(orderedMenusDto.getRequestOrders());
    }

    public Date from(DateDto dateDto) {
        return new Date(dateDto.getDate());
    }
}
