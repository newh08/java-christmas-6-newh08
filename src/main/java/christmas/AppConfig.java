package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.ChristmasEventController;
import christmas.model.service.ChristmasEventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {

    public ChristmasEventController getChristmasEventController() {
        return new ChristmasEventController(christmasEventService(), inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private ChristmasEventService christmasEventService() {
        return new ChristmasEventService();
    }

    public void endEvent() {
        Console.close();
    }
}
