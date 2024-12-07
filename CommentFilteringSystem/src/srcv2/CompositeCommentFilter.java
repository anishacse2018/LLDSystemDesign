package srcv2;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommentFilter implements FilterStrategy {
    List<FilterStrategy> filterStrategyList;

    CompositeCommentFilter() {
        filterStrategyList = new ArrayList<>();
    }

    public void addFilter(FilterStrategy filterStrategy) {
        filterStrategyList.add(filterStrategy);
    }

    public void removeFilter(FilterStrategy filterStrategy) {
        filterStrategyList.remove(filterStrategy);
    }

    public List<Comment> getFilteredComments(List<Comment> allComments) {
        List<Comment> comments = new ArrayList<>(allComments);
        for (FilterStrategy filterStrategy : filterStrategyList) {
            comments = filterStrategy.getFilteredComments(comments);
        }
        return comments;
    }
}
