package srcv2;

import java.util.List;

public interface FilterStrategy {
    List<Comment> getFilteredComments(List<Comment> allComments);
}
