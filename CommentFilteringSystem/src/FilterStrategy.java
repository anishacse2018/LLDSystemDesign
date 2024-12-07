import java.util.List;

public interface FilterStrategy<T> {
    List<Comment> getFilteredComments(List<Comment> allComments, T text);
}
