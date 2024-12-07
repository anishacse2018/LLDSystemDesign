package srcv2;

import java.util.List;
import java.util.stream.Collectors;

public class TextBasedFiltering implements FilterStrategy {

    private final String filterCriteria;

    public TextBasedFiltering(String filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    public List<Comment> getFilteredComments(List<Comment> allComments) {
        return allComments.stream().
                filter(comment -> comment.getDescription().contains(filterCriteria)).
                collect(Collectors.toList());

    }
}
