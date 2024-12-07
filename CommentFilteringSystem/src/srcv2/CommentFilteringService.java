package srcv2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentFilteringService {

    private volatile static CommentFilteringService commentFilteringService;
    private final CreateCommentFilterFactory createCommentFilterFactory;
    Map<Long, Product> productMap = new HashMap<>();

    public CommentFilteringService() {
        productMap = new HashMap<>();
        createCommentFilterFactory = new CreateCommentFilterFactory();
    }

    //Singleton Pattern with Double-checked Locking
    public static CommentFilteringService getCommentFilteringService() {
        if (commentFilteringService == null) {
            synchronized (CommentFilteringService.class) {
                if (commentFilteringService == null) {
                    return new CommentFilteringService();
                }
            }
        }
        return commentFilteringService;
    }

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public void removeProduct(Product product) {
        productMap.remove(product.getProductId());
    }

    public List<Comment> filterComments(List<FilterBy> filterBy, List<String> text, Product product) {
        CompositeCommentFilter compositeCommentFilter = new CompositeCommentFilter();
        int index = 0;
        for (FilterBy filter : filterBy) {
            compositeCommentFilter.addFilter(createCommentFilterFactory.createCommentFilter(filter, text.get(index)));
            index++;
        }
        return compositeCommentFilter.getFilteredComments(product.getCommentList());
    }

}
