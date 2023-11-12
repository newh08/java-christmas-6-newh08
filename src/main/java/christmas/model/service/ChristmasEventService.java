package christmas.model.service;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.event.EventRepository;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.RequestOrder;
import christmas.model.util.Converter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasEventService {
    private static final int MINIMUM_EVENT_PRICE = 10000;

    private final Converter converter;

    public ChristmasEventService(Converter converter) {
        this.converter = converter;
    }

    public OrderedMenusDto makeOrderMenusDto(List<RequestOrder> requestOrderList) {
        OrderedMenus orderedMenus = new OrderedMenus(requestOrderList);
        return Converter.from(orderedMenus);
    }

    public EventResultsDto makeEventResultsDto(OrderedMenusDto orderedMenusDto, DateDto dateDto) {
        EventResults eventResults = EventResults.makeInitialConditionEventResults();
        if (checkTotalOrderPriceOverMinimumEventPrice(orderedMenusDto)) {
            executeEvent(orderedMenusDto, dateDto, eventResults);
        }
        saveEventResult(eventResults);
        return converter.from(eventResults);
    }

    private static boolean checkTotalOrderPriceOverMinimumEventPrice(OrderedMenusDto orderedMenusDto) {
        return orderedMenusDto.getTotalOrderPrice() >= MINIMUM_EVENT_PRICE;
    }

    private void executeEvent(OrderedMenusDto orderedMenusDto, DateDto dateDto, EventResults eventResults) {
        OrderedMenus orderedMenus = converter.from(orderedMenusDto);
        Date date = converter.from(dateDto);
        eventResults.updateEventResult(orderedMenus, date);
    }

    private void saveEventResult(EventResults eventResults) {
        EventRepository.getEventRepository().save(eventResults);
    }
}
