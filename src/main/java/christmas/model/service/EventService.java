package christmas.model.service;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.dto.RequestDateDto;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.util.Converter;

public class EventService {
    private static final int MINIMUM_EVENT_PRICE = 10000;

    public Date makeDate(RequestDateDto requestDateDto) {
        int date = requestDateDto.getDate();
        return new Date(date);
    }

    public EventResultsDto makeEventResults(OrderedMenusDto orderedMenusDto, Date date) {
        EventResults eventResults = new EventResults();
        if (orderedMenusDto.getTotalOrderPrice() >= MINIMUM_EVENT_PRICE) {
            OrderedMenus orderedMenus = Converter.from(orderedMenusDto);
            eventResults.updateEventResult(orderedMenus, date);
        }
        return Converter.from(eventResults);
    }
}
