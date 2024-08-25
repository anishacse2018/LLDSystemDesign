package model;

import java.util.*;

public class Topic {
   private String topicId;
   private String topicName;
   private Set<Subscriber> subscribers;

    public Topic(String topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.subscribers = new HashSet<>();
    }

    public void addSubscriber(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void publish(Message message){
        for(Subscriber subscriber: this.subscribers){
            System.out.println("Subscriber "+subscriber.getSubscriberName() +
                               " Received the message: "+message.getMessage());
        }
    }

}
