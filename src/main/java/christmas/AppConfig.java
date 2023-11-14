package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.ChristmasEventController;
import christmas.model.domain.event.ChristmasEventStrategy;
import christmas.model.domain.event.EventRepository;
import christmas.model.domain.event.EventStrategy;
import christmas.model.domain.event.benefit.ChristmasTotalDiscount;
import christmas.model.service.ChristmasEventService;
import christmas.model.util.Converter;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {

    public ChristmasEventController getChristmasEventController() {
        return new ChristmasEventController(christmasEventService(), inputView(), outputView());
    }

    private ChristmasEventService christmasEventService() {
        return new ChristmasEventService(converter(), eventRepository(), christmasEventStrategy());
    }

    private Converter converter() {
        return new Converter();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private EventRepository eventRepository() {
        return EventRepository.getEventRepository();
    }

    private EventStrategy christmasEventStrategy() {
        return new ChristmasEventStrategy(christmasTotalDiscount());
    }

    private ChristmasTotalDiscount christmasTotalDiscount() {
        return new ChristmasTotalDiscount();
    }

    public void endEvent() {
        Console.close();
    }
}
