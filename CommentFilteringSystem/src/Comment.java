import java.time.Instant;

public class Comment {

    private String description;
    private Long commentId;
    private String postedBy;
    private Instant timestamp;

    public Comment(String description, Long commentId, String postedBy, Instant timestamp) {
        this.description = description;
        this.commentId = commentId;
        this.postedBy = postedBy;
        this.timestamp = timestamp;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
