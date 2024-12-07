package model;

import java.util.List;

public class Questions extends StackOverFlowEntity {
    private List<String> tags;
    private List<Answers> answers;
    private List<Comment> comments;

    public Questions(Integer id, String description) {
        super(id, description);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addAnswer(Answers answers) {
        this.answers.add(answers);
    }

    public void addTag(String tag) {
        tags.add(tag);
    }

}
