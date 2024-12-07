package srcv2;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class TimeBasedFiltering implements FilterStrategy {

    private final Instant filterCriteria;

    TimeBasedFiltering(Instant filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    public List<Comment> getFilteredComments(List<Comment> allComments) {
        return allComments.stream().
                filter(comment -> comment.getTimestamp().isBefore(filterCriteria)).
                collect(Collectors.toList());
    }
}
