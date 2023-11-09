package christmas.model.domain.order;

public class Price {
    private int price;

    public Price() {
        this.price = 0;
    }

    public void updatePrice(RequestOrder requestOrder) {
        price += requestOrder.getOrderPrice();
    }

    public int getPrice() {
        return price;
    }
}
