package christmas.model.domain.order;

import static christmas.model.util.ErrorMessage.OVER_MAX_MENU_MESSAGE;
import static christmas.model.util.ErrorMessage.WRONG_ORDER_ONLY_BEVERAGE;

import christmas.model.domain.date.Date;
import christmas.model.domain.event.EventResults;
import christmas.model.domain.event.strategy.EventStrategy;
import christmas.model.domain.menu.MenuCategory;
import christmas.model.util.MyIllegalArgumentException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RequestOrders {
    private static final int MAX_NUMBER_OF_MENU = 20;

    private final List<RequestOrder> requestOrders;

    public RequestOrders(List<RequestOrder> requestOrders) {
        validateRequestOrders(requestOrders);
        this.requestOrders = requestOrders;
    }

    private void validateRequestOrders(List<RequestOrder> requestOrders) {
        validateTotalOrderQuantity(requestOrders);
        validateMenuContainNonBeverage(requestOrders);
    }

    private void validateTotalOrderQuantity(List<RequestOrder> requestOrders) {
        int totalMenuQuantity = requestOrders.stream()
                .mapToInt(RequestOrder::getQuantity)
                .sum();
        if (totalMenuQuantity > MAX_NUMBER_OF_MENU) {
            throw new MyIllegalArgumentException(OVER_MAX_MENU_MESSAGE);
        }
    }

    private void validateMenuContainNonBeverage(List<RequestOrder> requestOrders) {
        boolean isAllBeverage = requestOrders.stream()
                .allMatch(requestOrder -> requestOrder.checkCatalog(MenuCategory.BEVERAGE));
        if (isAllBeverage) {
            throw new MyIllegalArgumentException(WRONG_ORDER_ONLY_BEVERAGE);
        }
    }

    public int getNumberOfSpecificCatalogOrder(MenuCategory menuCategory) {
        return requestOrders.stream()
                .filter(order -> order.checkCatalog(menuCategory))
                .mapToInt(RequestOrder::getQuantity)
                .sum();
    }

    public String makeOrdersMessage() {
        return requestOrders.stream()
                .map(RequestOrder::toString)
                .collect(Collectors.joining("\n"));
    }

    public TotalOrderPrice getTotalOrderPrice() {
        TotalOrderPrice totalOrderPrice = new TotalOrderPrice();
        for (RequestOrder requestOrder : requestOrders) {
            totalOrderPrice.updateTotalOrderPrice(requestOrder);
        }
        return totalOrderPrice;
    }

    public EventResults applyEvent(EventStrategy eventStrategy, Date date) {
        if (getTotalOrderPrice().isUnderMinimumEventPrice(eventStrategy)) {
            return EventResults.makeZeroEventResults();
        }
        return eventStrategy.updateEventResult(this, date);
    }

    public List<RequestOrder> getRequestOrders() {
        return Collections.unmodifiableList(requestOrders);
    }
}
