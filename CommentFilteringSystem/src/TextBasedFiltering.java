import java.util.List;
import java.util.stream.Collectors;

public class TextBasedFiltering implements FilterStrategy<String> {

    public List<Comment> getFilteredComments(List<Comment> allComments, String text) {
        return allComments.stream().
                filter(comment -> comment.getDescription().contains(text)).
                collect(Collectors.toList());

    }
}
