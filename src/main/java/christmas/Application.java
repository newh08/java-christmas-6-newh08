package christmas;

import christmas.controller.ChristmasEventController;
import christmas.model.service.ChristmasEventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        ChristmasEventController controller = new ChristmasEventController(new ChristmasEventService(),
                new InputView(), new OutputView());
        controller.start();
    }
}
