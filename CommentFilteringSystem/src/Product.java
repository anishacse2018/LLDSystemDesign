import java.util.ArrayList;
import java.util.List;

public class Product {

    List<Comment> commentList;
    String productName;
    Long productId;

    public Product(String productName, Long productId) {
        this.productName = productName;
        this.productId = productId;
        this.commentList = new ArrayList<>();
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addCommentToProduct(Comment comment) {
        this.commentList.add(comment);
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
