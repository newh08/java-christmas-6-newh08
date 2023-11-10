package christmas.model.domain.order;

import christmas.model.domain.event.Gift;

public class Price {
    private int price;

    public Price() {
        this.price = 0;
    }

    public void updatePrice(RequestOrder requestOrder) {
        price += requestOrder.getOrderPrice();
    }

    public Gift makeGiftAccordingOrderPrice() {
        return new Gift(price);
    }

    public int getPrice() {
        return price;
    }
}
