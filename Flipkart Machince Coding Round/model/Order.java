package model;

import java.time.Instant;

public class Order {
    private String orderId;
    private String productId;
    private OrderStatus orderStatus;
    private String categoryId;
    private String sellerId;
    private Instant orderTimestamp;
    private String brand;
    private String affiliateId;
    private double sellingPrice;
    private double commission;

    public Order(String orderId, String productId, OrderStatus orderStatus, String categoryId, String sellerId, Instant orderTimestamp, String brand, String affiliateId, double sellingPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderStatus = orderStatus;
        this.categoryId = categoryId;
        this.sellerId = sellerId;
        this.orderTimestamp = orderTimestamp;
        this.brand = brand;
        this.affiliateId = affiliateId;
        this.sellingPrice = sellingPrice;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Instant getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(Instant orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
