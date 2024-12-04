package model;

import java.util.ArrayList;
import java.util.List;

public class Affiliate {
    private String affiliateId;
    private String affiliateName;
    private List<Product> productList;
    private List<Transaction> transactions;
    private List<Order> orders;
    private List<OrderCommission> orderCommissions;

    public Affiliate(String affiliateId, String affiliateName, List<Product> productList) {
        this.affiliateId = affiliateId;
        this.affiliateName = affiliateName;
        this.productList = productList;
        this.transactions = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.orderCommissions = new ArrayList<>();
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public String getAffiliateName() {
        return affiliateName;
    }

    public void setAffiliateName(String affiliateName) {
        this.affiliateName = affiliateName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<OrderCommission> getOrderCommissions() {
        return orderCommissions;
    }

    public void setOrderCommissions(List<OrderCommission> orderCommissions) {
        this.orderCommissions = orderCommissions;
    }

    public double getTotalEarnings() {
        return getTransactions().stream()
                .mapToDouble(Transaction::getTotalAmountPaid)
                .sum();
    }
}
