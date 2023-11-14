package christmas.model.domain.order;

import christmas.model.domain.event.benefit.Gift;

public class TotalOrderPrice {
    private static final int MINIMUM_EVENT_PRICE = 10000;

    private int totalOrderPrice;

    public TotalOrderPrice() {
        this.totalOrderPrice = 0;
    }

    public void updateTotalOrderPrice(RequestOrder requestOrder) {
        totalOrderPrice += requestOrder.getOrderPrice();
    }

    public Gift makeGiftPerTotalOrderPrice() {
        return new Gift(totalOrderPrice);
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public boolean isUnderMinimumEventPrice() {
        return totalOrderPrice < MINIMUM_EVENT_PRICE;
    }
}
