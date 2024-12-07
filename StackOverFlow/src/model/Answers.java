package model;

import java.util.List;

public class Answers extends StackOverFlowEntity {
    List<Comment> comments;

    public Answers(Integer id, String description) {
        super(id, description);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
