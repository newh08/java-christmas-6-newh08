package christmas;

import christmas.controller.ChristmasEventController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ChristmasEventController christmasEventController = appConfig.getChristmasEventController();
        christmasEventController.startEvent();
        appConfig.endEvent();
    }
}
