package srcv2;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class CommentFilter {
    private static CommentFilteringService commentFilteringService;

    public CommentFilter() {
        commentFilteringService = CommentFilteringService.getCommentFilteringService();
    }

    private static void printFilteredComments(List<Comment> comments) {
        for (Comment filteredComment : comments) {
            System.out.println("Comment Description: " + filteredComment.getDescription());
            System.out.println("Comment ID: " + filteredComment.getCommentId());
        }
    }

    public void run() {
        Product product1 = new Product("Blue shirt", 1L);
        Product product2 = new Product("Red gown", 2L);
        Comment comment = new Comment("Added comment", 1L, "Anisha", Instant.now());
        Comment comment1 = new Comment("Added comment1", 2L, "Anisha", Instant.now());
        Comment comment2 = new Comment("Added comment2", 3L, "Vanshika", Instant.now());
        product1.addCommentToProduct(comment);
        product1.addCommentToProduct(comment1);
        product2.addCommentToProduct(comment2);
        commentFilteringService.addProduct(product1);
        commentFilteringService.addProduct(product2);
        List<Comment> comments = commentFilteringService.filterComments(List.of(FilterBy.TEXT), List.of("comment"), product1);
        printFilteredComments(comments);
        product1.removeCommentForProduct(comment1);
        comments = commentFilteringService.filterComments(Arrays.asList(FilterBy.POSTED, FilterBy.TEXT), List.of("Anisha"), product1);
        printFilteredComments(comments);
    }
}




