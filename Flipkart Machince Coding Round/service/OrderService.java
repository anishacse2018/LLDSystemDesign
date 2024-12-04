package service;

import model.Order;
import model.OrderCommission;
import model.OrderStatus;
import strategy.CommissionFactory;
import strategy.CommissionStrategy;

public class OrderService {

    public OrderCommission processOrder(Order order) {
        if (order.getOrderStatus().equals(OrderStatus.ORDER_CANCELLED))
            return new OrderCommission(order.getOrderId(), 0.0);
        else {
            CommissionStrategy strategy = CommissionFactory.getCommissionStrategy(order.getBrand(), order.getCategoryId());
            double commissionAmount = strategy.calculateCommission(order.getSellingPrice());
            OrderCommission orderCommission = new OrderCommission(order.getOrderId(), commissionAmount);
            order.setCommission(commissionAmount);
            return orderCommission;
        }
    }
}
