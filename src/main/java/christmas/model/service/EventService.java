package christmas.model.service;

import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.RequestOrdersDto;
import java.util.Map;

public interface EventService {
    DateDto makeDateDto(int userInputDate);

    RequestOrdersDto makeRequestOrdersDto(Map<String, Integer> inputOrders);

    EventResultsDto makeEventResultsDto(RequestOrdersDto requestOrdersDto, DateDto dateDto);
}
