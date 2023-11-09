package christmas.model.domain.order;

import java.util.ArrayList;
import java.util.List;

public class RequestOrders {
    private final List<RequestOrder> requestOrders;
    private final Price totalPrice;

    public RequestOrders() {
        this.requestOrders = new ArrayList<>();
        totalPrice = new Price();
    }

    public void addRequestOrder(RequestOrder requestOrder) {
        requestOrders.add(requestOrder);
        totalPrice.updatePrice(requestOrder);
    }
}
