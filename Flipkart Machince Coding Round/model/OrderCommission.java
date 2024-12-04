package model;

public class OrderCommission {
    private final String orderId;
    private final double orderCommission;

    public OrderCommission(String orderId, double orderCommission) {
        this.orderId = orderId;
        this.orderCommission = orderCommission;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getOrderCommission() {
        return orderCommission;
    }
}


