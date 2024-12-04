package model;

public class Product {

    private final String productId;
    private final ProductCategory productCategory;
    private final String brand;
    private final double price;

    public Product(String productId, ProductCategory productCategory, String brand, double price) {
        this.productId = productId;
        this.productCategory = productCategory;
        this.brand = brand;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}
