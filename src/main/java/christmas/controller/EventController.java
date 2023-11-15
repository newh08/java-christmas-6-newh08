package christmas.controller;

import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.RequestOrdersDto;
import christmas.model.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;
import java.util.function.Supplier;

public class EventController {
    private final EventService eventService;
    private final InputView inputView;
    private final OutputView outputView;

    public EventController(EventService eventService, InputView inputView, OutputView outputView) {
        this.eventService = eventService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startEvent() {
        DateDto dateDto = repeat(this::makeDateDto);

        RequestOrdersDto requestOrdersDto = repeat(this::makeRequestOrdersDto);

        outputView.printStartOfBenefitInfo(dateDto);
        outputView.printOrder(requestOrdersDto);
        outputView.printTotalOrderPrice(requestOrdersDto);

        EventResultsDto eventResultsDto = eventService.makeEventResultsDto(requestOrdersDto, dateDto);
        outputView.printEventResult(eventResultsDto, requestOrdersDto);
    }

    private DateDto makeDateDto() {
        int userInputDate = inputView.readDate();
        return eventService.makeDateDto(userInputDate);
    }

    private RequestOrdersDto makeRequestOrdersDto() {
        Map<String, Integer> userInputOrders = inputView.readOrders();
        return eventService.makeRequestOrdersDto(userInputOrders);
    }

    private <T> T repeat(Supplier<T> something) {
        while (true) {
            try {
                return something.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
