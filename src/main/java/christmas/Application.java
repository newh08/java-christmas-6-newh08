package christmas;

import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        EventController christmasEventController = appConfig.getChristmasEventController();
        christmasEventController.startEvent();
        appConfig.endEvent();
    }
}
