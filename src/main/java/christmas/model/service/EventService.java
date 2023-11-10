package christmas.model.service;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.RequestDateDto;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;

public class EventService {
    private static final int MINIMUM_EVENT_PRICE = 10000;

    public Date makeDate(RequestDateDto requestDateDto) {
        int date = requestDateDto.getDate();
        return new Date(date);
    }

    public EventResults makeEventResults(OrderedMenus orderedMenus, Date date) {
        EventResults eventResults = new EventResults();
        if (orderedMenus.getTotalOrderPrice() >= MINIMUM_EVENT_PRICE) {
            eventResults.updateEventResult(orderedMenus, date);
        }
        return eventResults;
    }
}
