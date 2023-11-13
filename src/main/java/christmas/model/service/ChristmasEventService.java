package christmas.model.service;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.event.EventRepository;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.RequestOrder;
import christmas.model.domain.order.RequestOrders;
import christmas.model.util.Converter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasEventService {
    private static final int MINIMUM_EVENT_PRICE = 10000;

    private final Converter converter;
    private final EventRepository eventRepository;
    private long runtimeUserId;

    public ChristmasEventService(Converter converter) {
        this.converter = converter;
        this.eventRepository = EventRepository.getEventRepository();
    }

    public DateDto makeDateDto(int userInputDate) {
        return converter.from(userInputDate);
    }

    public OrderedMenusDto makeOrderedMenusDto(Map<String, Integer> inputOrders) {
        List<RequestOrder> convertedRequestOrders = inputOrders.entrySet().stream()
                                                        .map(converter::from)
                                                        .collect(Collectors.toList());
        RequestOrders requestOrders = new RequestOrders(convertedRequestOrders);
        OrderedMenus orderedMenus = new OrderedMenus(requestOrders);
        return converter.from(orderedMenus);
    }

    public EventResultsDto makeEventResultsDto(OrderedMenusDto orderedMenusDto, DateDto dateDto) {
        EventResults eventResults = EventResults.makeInitialConditionEventResults();
        if (checkTotalOrderPriceOverMinimumEventPrice(orderedMenusDto)) {
            executeEvent(orderedMenusDto, dateDto, eventResults);
        }
        runtimeUserId = eventRepository.save(eventResults);
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
}
