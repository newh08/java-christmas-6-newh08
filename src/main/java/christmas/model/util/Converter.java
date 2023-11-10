package christmas.model.util;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.RequestOrderDto;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;
import java.util.Map.Entry;

public class Converter {
    public static EventResultsDto from(final EventResults eventResults) {
        return new EventResultsDto(eventResults.getTotalDiscount(), eventResults.getGift(),
                eventResults.getTotalBenefitAmount(), eventResults.getBadge());
    }

    public static OrderedMenusDto from(final OrderedMenus orderedMenus) {
        return new OrderedMenusDto(orderedMenus.getRequestOrders(), orderedMenus.getTotalPrice());
    }

    public static DateDto from(final int inputDate) {
        return new DateDto(inputDate);
    }

    public static RequestOrderDto from(Entry<String, Integer> input) {
        String inputMenu = input.getKey();
        Integer inputQuantity = input.getValue();
        return new RequestOrderDto(inputMenu, inputQuantity);
    }

    public static OrderedMenus from(OrderedMenusDto orderedMenusDto) {
        return new OrderedMenus(orderedMenusDto.getRequestOrders());
    }

    public static Date from(DateDto dateDto) {
        return new Date(dateDto.getDate());
    }
}
