package srcv2;

import java.util.List;
import java.util.stream.Collectors;

public class PostedByFiltering implements FilterStrategy {

    private final String filterCriteria;

    public PostedByFiltering(String filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    public List<Comment> getFilteredComments(List<Comment> allComments) {
        return allComments.stream().
                filter(comment -> comment.getPostedBy().contains(filterCriteria)).
                collect(Collectors.toList());
    }
}
