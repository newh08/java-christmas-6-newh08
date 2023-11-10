package christmas.model.util;

import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.dto.RequestDateDto;
import christmas.model.domain.dto.RequestOrderDto;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;

public class Converter {
    public static EventResultsDto from(final EventResults eventResults) {
        return new EventResultsDto(eventResults.getTotalDiscount(), eventResults.getGift(),
                eventResults.getTotalBenefitAmount(), eventResults.getBadge());
    }

    public static OrderedMenusDto from(final OrderedMenus orderedMenus) {
        return new OrderedMenusDto(orderedMenus.getRequestOrders(), orderedMenus.getTotalPrice());
    }

    public static RequestDateDto from(final int inputDate) {
        return new RequestDateDto(inputDate);
    }

    public static RequestOrderDto from(final String inputMenu, final int inputQuantity) {
        return new RequestOrderDto(inputMenu, inputQuantity);
    }
}
