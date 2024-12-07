import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class TimeBasedFiltering implements FilterStrategy<Instant> {
    public List<Comment> getFilteredComments(List<Comment> allComments, Instant text) {
        return allComments.stream().
                filter(comment -> comment.getTimestamp().isBefore(text)).
                collect(Collectors.toList());
    }
}
