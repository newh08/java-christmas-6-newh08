package christmas.model.domain.order;

import christmas.model.domain.event.strategy.EventStrategy;

public class TotalOrderPrice {

    private int totalOrderPrice;

    public TotalOrderPrice() {
        this.totalOrderPrice = 0;
    }

    public void updateTotalOrderPrice(RequestOrder requestOrder) {
        totalOrderPrice += requestOrder.getOrderPrice();
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public boolean isUnderMinimumEventPrice(EventStrategy eventStrategy) {
        return totalOrderPrice < eventStrategy.getMinimumOrderPrice();
    }
}
