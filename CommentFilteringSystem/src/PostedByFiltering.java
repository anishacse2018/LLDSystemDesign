import java.util.List;
import java.util.stream.Collectors;

public class PostedByFiltering implements FilterStrategy<String> {
    public List<Comment> getFilteredComments(List<Comment> allComments, String text) {
        return allComments.stream().
                filter(comment -> comment.getPostedBy().contains(text)).
                collect(Collectors.toList());

    }
}
