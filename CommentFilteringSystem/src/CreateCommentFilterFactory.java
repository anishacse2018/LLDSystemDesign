public class CreateCommentFilterFactory {

    public FilterStrategy createCommentFilter(FilterBy condition) {
        if (condition.equals(FilterBy.TEXT)) {
            return new TextBasedFiltering();
        } else if (condition.equals(FilterBy.POSTED)) {
            return new PostedByFiltering();
        }
        return new TimeBasedFiltering();
    }
}
