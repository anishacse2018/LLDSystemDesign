package srcv2;

import java.util.ArrayList;
import java.util.List;


public class Product implements Subject {

    List<Comment> commentList;
    String productName;
    Long productId;
    List<Observer> observers;

    public Product(String productName, Long productId) {
        this.productName = productName;
        this.productId = productId;
        this.commentList = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }


    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(Comment comment) {
        this.observers.forEach(observer -> {
            observer.notifyObserver(comment, this.productId);
        });
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addCommentToProduct(Comment comment) {

        this.commentList.add(comment);
        notifyObservers(comment);
    }

    public void removeCommentForProduct(Comment comment) {
        this.commentList.remove(comment);
        System.out.println("The comment is not present for the current product");
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
