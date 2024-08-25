import model.Message;
import model.Publisher;
import model.Subscriber;
import model.Topic;

public class Main {
    public static void main(String[] args) {

        System.out.println("PubSub System Demo!");
        Topic topic1 = new Topic("1","Topic 1");
        Topic topic2 = new Topic("2","Topic 2");

        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        publisher1.addTopic(topic1);
        publisher2.addTopic(topic2);

        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");
        Subscriber subscriber3 = new Subscriber("Subscriber 3");

        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber3);

        publisher1.publish(topic1,new Message("Message1 from Topic1"));
        publisher1.publish(topic2,new Message("Message2 from Topic2"));
        publisher2.publish(topic2,new Message("Message1 from Topic1 again"));

        topic1.removeSubscriber(subscriber3);

        publisher1.publish(topic1,new Message("Message3 for Topic1"));
        publisher2.publish(topic2,new Message("Message4 for Topic2"));

    }
}
