package christmas.model.service;

import christmas.model.domain.date.Date;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.RequestOrdersDto;
import christmas.model.domain.event.EventRepository;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.event.strategy.EventStrategy;
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

    public RequestOrdersDto makeRequestOrdersDto(Map<String, Integer> inputOrders) {
        List<RequestOrder> convertedRequestOrders = inputOrders.entrySet().stream()
                                                        .map(converter::from)
                                                        .collect(Collectors.toList());
        RequestOrders requestOrders = new RequestOrders(convertedRequestOrders);
        return converter.from(requestOrders);
    }

    public EventResultsDto makeEventResultsDto(RequestOrdersDto requestOrdersDto, DateDto dateDto) {
        EventResults eventResults = executeEvent(requestOrdersDto, dateDto, eventStrategy);
        runtimeUserId = eventRepository.save(eventResults);
        return converter.from(eventResults);
    }

    private EventResults executeEvent(RequestOrdersDto requestOrdersDto, DateDto dateDto, EventStrategy eventStrategy) {
        RequestOrders requestOrders = converter.from(requestOrdersDto);
        Date date = converter.from(dateDto);
        return requestOrders.applyEvent(eventStrategy, date);

    }
}
