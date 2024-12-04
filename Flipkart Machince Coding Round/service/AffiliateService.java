package service;

import model.Affiliate;
import model.Order;
import model.OrderCommission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AffiliateService {

    private final OrderService orderService;
    private final TransactionService transactionService;
    Map<String, Affiliate> affiliateMap = new HashMap<>();

    public AffiliateService() {
        this.orderService = new OrderService();
        this.transactionService = new TransactionService();
    }

    public void createAffiliate(Affiliate affiliate) {
        affiliateMap.put(affiliate.getAffiliateId(), affiliate);
    }

    public void placeOrder(Affiliate affiliate, Order order) {
        OrderCommission orderCommission = orderService.processOrder(order);
        if (orderCommission.getOrderCommission() != 0.0) {
            List<Order> orders = affiliate.getOrders();
            orders.add(order);
            affiliate.getOrderCommissions().add(orderCommission);
            double transactionAmount = affiliate.getOrderCommissions().stream()
                    .mapToDouble(OrderCommission::getOrderCommission)
                    .sum();
            if (isTransactionAmountGreaterThanHundred(transactionAmount)) {
                transactionService.createTransaction(affiliate, transactionAmount);
            }
        }
    }

    boolean isTransactionAmountGreaterThanHundred(double transactionAmount) {
        return transactionAmount > 100;
    }
}
