package srcv2;

import java.time.Instant;

public class CreateCommentFilterFactory<T> {

    public FilterStrategy createCommentFilter(FilterBy condition, T filterCriteria) {
        if (condition.equals(FilterBy.TEXT)) {
            return new TextBasedFiltering((String) filterCriteria);
        } else if (condition.equals(FilterBy.POSTED)) {
            return new PostedByFiltering((String) filterCriteria);
        } else if (condition.equals(FilterBy.TIME)) {
            return new TimeBasedFiltering((Instant) filterCriteria);
        }
        return new CompositeCommentFilter();
    }
}
