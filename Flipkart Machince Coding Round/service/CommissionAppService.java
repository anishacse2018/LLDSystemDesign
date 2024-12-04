package service;

import model.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CommissionAppService {

    private static final CommissionAppService commissionAppService = new CommissionAppService();
    private final AffiliateService affiliateService;

    CommissionAppService() {
        this.affiliateService = new AffiliateService();
    }

    public static CommissionAppService getCommissionAppService() {
        return commissionAppService;
    }

    private static void affiliatePayOuts(Affiliate affiliate) {
        List<Transaction> transactions = affiliate.getTransactions();
        for (Transaction transaction : transactions) {
            System.out.println("Transaction is: " + transaction.getTransactionId() + " " + transaction.getTotalAmountPaid() + " ");
            for (OrderCommission orderCommission : transaction.getOrderCommissionList()) {
                System.out.println("OrderId: " + " " + orderCommission.getOrderId());
                System.out.println("CommissionAmount: " + " " + orderCommission.getOrderCommission());
            }
        }
    }

    public void execute() {
        Product product1 = new Product("1", new ProductCategory("1", "Mobiles"), "APPLE", 100000.00);
        Product product2 = new Product("2", new ProductCategory("2", "Mobile Covers"), "Samsung", 200);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        Affiliate affiliate = new Affiliate("1", "affialiate1", products);
        Affiliate affiliate1 = new Affiliate("2", "affialiate2", products);
        affiliateService.createAffiliate(affiliate);
        affiliateService.createAffiliate(affiliate1);
        Order order = new Order("order1", "1", OrderStatus.ORDER_CREATED, "1", "Samsung", Instant.now(), "APPLE", "1", 100000.00);
        // Order order1 = new Order("order2", "2", OrderStatus.ORDER_CANCELLED, "1", "Samsung", Instant.now(), "APPLE", "1", 100000.00);
        //order.setOrderStatus(OrderStatus.ORDER_CANCELLED);
        Order order2 = new Order("order2", "1", OrderStatus.ORDER_CREATED, "1", "Samsung", Instant.now(), "APPLE", "1", 600.00);
        Order order3 = new Order("order3", "1", OrderStatus.ORDER_CREATED, "1", "Samsung", Instant.now(), "APPLE", "1", 700.00);
        affiliateService.placeOrder(affiliate, order2);
        affiliateService.placeOrder(affiliate, order3);
        affiliateService.placeOrder(affiliate1, order);
        //affiliateService.placeOrder(affiliate1, order1);
        // order.setOrderStatus(OrderStatus.ORDER_CANCELLED);
        affiliatePayOuts(affiliate1);
        affiliatePayOuts(affiliate);
        System.out.println("Total Affiliate Earnings: " + affiliate.getTotalEarnings());
        System.out.println("Total Affiliate1 earnings: " + affiliate1.getTotalEarnings());
    }
}
