package srcv2;

public class User implements Observer {

    public void notifyObserver(Comment comment, Long productId) {
        System.out.println("Comment has been added to the Product: " + productId);
        System.out.println("The comment is: " + comment.getDescription() + " " + comment.getCommentId());
    }
}
