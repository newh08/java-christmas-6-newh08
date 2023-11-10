package christmas.model.domain.order;

import christmas.model.domain.event.Gift;

public class TotalOrderPrice {
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
}
