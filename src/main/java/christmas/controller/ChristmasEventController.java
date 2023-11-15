package christmas.controller;

import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.dto.RequestOrdersDto;
import christmas.model.service.ChristmasEventService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;
import java.util.function.Supplier;

public class ChristmasEventController {
    private final ChristmasEventService christmasEventService;
    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasEventController(ChristmasEventService christmasEventService, InputView inputView, OutputView outputView) {
        this.christmasEventService = christmasEventService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startEvent() {
        DateDto dateDto = repeat(this::makeDateDto);

        RequestOrdersDto requestOrdersDto = repeat(this::makeRequestOrdersDto);

        outputView.printStartOfBenefitInfo(dateDto);
        outputView.printOrder(requestOrdersDto);
        outputView.printTotalOrderPrice(requestOrdersDto);

        EventResultsDto eventResultsDto = christmasEventService.makeEventResultsDto(requestOrdersDto, dateDto);
        outputView.printEventResult(eventResultsDto, requestOrdersDto);
    }

    private DateDto makeDateDto() {
        int userInputDate = inputView.readDate();
        return christmasEventService.makeDateDto(userInputDate);
    }

    private RequestOrdersDto makeRequestOrdersDto() {
        Map<String, Integer> userInputOrders = inputView.readOrders();
        return christmasEventService.makeRequestOrdersDto(userInputOrders);
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
