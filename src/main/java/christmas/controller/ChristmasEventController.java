package christmas.controller;

import christmas.model.domain.dto.EventResultsDto;
import christmas.model.domain.dto.OrderedMenusDto;
import christmas.model.domain.dto.DateDto;
import christmas.model.domain.order.RequestOrder;
import christmas.model.service.ChristmasEventService;
import christmas.model.util.Converter;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
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

        OrderedMenusDto orderedMenusDto = repeat(this::makeOrderMenusDto);

        outputView.printStartOfBenefitInfo(dateDto);
        outputView.printOrder(orderedMenusDto);
        outputView.printTotalOrderPrice(orderedMenusDto);

        EventResultsDto eventResultsDto = christmasEventService.makeEventResults(orderedMenusDto, dateDto);
        outputView.printEventResult(eventResultsDto, orderedMenusDto);
    }

    private DateDto makeDateDto() {
        int userInputDate = repeat(inputView::readDate);
        return Converter.from(userInputDate);
    }

    private OrderedMenusDto makeOrderMenusDto() {
        Map<String, Integer> userInputOrders = inputView.readOrders();
        List<RequestOrder> requestOrders = makeRequestOrders(userInputOrders);
        return christmasEventService.makeOrderMenusDto(requestOrders);
    }

    private List<RequestOrder> makeRequestOrders(Map<String, Integer> userInputOrders) {
        return userInputOrders.entrySet().stream()
                .map(Converter::from)
                .map(christmasEventService::makeRequestOrder)
                .toList();
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
