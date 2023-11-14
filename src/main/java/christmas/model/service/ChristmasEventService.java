package christmas.model.service;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.event.EventRepository;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.event.EventStrategy;
import christmas.model.domain.order.OrderedMenus;
import christmas.model.domain.order.RequestOrder;
import christmas.model.domain.order.RequestOrders;
import christmas.model.util.Converter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChristmasEventService {

    private final Converter converter;
    private final EventRepository eventRepository;
    private final EventStrategy eventStrategy;
    private long runtimeUserId;

    public ChristmasEventService(Converter converter, EventRepository eventRepository, EventStrategy eventStrategy) {
        this.converter = converter;
        this.eventRepository = eventRepository;
        this.eventStrategy = eventStrategy;
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
        EventResults eventResults = executeEvent(orderedMenusDto, dateDto, eventStrategy);
        runtimeUserId = eventRepository.save(eventResults);
        return converter.from(eventResults);
    }

    private EventResults executeEvent(OrderedMenusDto orderedMenusDto, DateDto dateDto, EventStrategy eventStrategy) {
        OrderedMenus orderedMenus = converter.from(orderedMenusDto);
        Date date = converter.from(dateDto);
        return orderedMenus.applyEvent(eventStrategy, date);

    }
}
