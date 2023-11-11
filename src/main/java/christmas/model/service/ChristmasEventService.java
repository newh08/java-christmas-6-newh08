package christmas.model.service;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.dto.RequestOrderDto;
import christmas.model.domain.event.EventRepository;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.RequestOrder;
import christmas.model.util.Converter;
import java.util.List;

public class ChristmasEventService {
    private static final int MINIMUM_EVENT_PRICE = 10000;

    public RequestOrder makeRequestOrder(RequestOrderDto requestOrderDto) {
        String menuName = requestOrderDto.getMenuName();
        int quantity = requestOrderDto.getQuantity();
        return new RequestOrder(menuName, quantity);
    }

    public OrderedMenusDto makeOrderMenusDto(List<RequestOrder> requestOrderList) {
        OrderedMenus orderedMenus = new OrderedMenus(requestOrderList);
        return Converter.from(orderedMenus);
    }

    public EventResultsDto makeEventResults(OrderedMenusDto orderedMenusDto, DateDto dateDto) {
        EventResults eventResults = EventResults.makeInitialConditionEventResults();
        if (checkTotalOrderPriceOverMinimumEventPrice(orderedMenusDto)) {
            executeEvent(orderedMenusDto, dateDto, eventResults);
        }
        saveEventResult(eventResults);
        return Converter.from(eventResults);
    }

    private static boolean checkTotalOrderPriceOverMinimumEventPrice(OrderedMenusDto orderedMenusDto) {
        return orderedMenusDto.getTotalOrderPrice() >= MINIMUM_EVENT_PRICE;
    }

    private void executeEvent(OrderedMenusDto orderedMenusDto, DateDto dateDto, EventResults eventResults) {
        OrderedMenus orderedMenus = Converter.from(orderedMenusDto);
        Date date = Converter.from(dateDto);
        eventResults.updateEventResult(orderedMenus, date);
    }

    private void saveEventResult(EventResults eventResults) {
        EventRepository.getEventRepository().save(eventResults);
    }
}
