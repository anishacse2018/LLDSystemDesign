package model;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Topic> topics;

    public Publisher() {
        this.topics = new ArrayList<>();
    }

    public void addTopic(Topic topic){
      this.topics.add(topic);
    }

    public void publish(Topic topic,Message message){
        if(!topics.contains(topic)) {
            System.out.println("This publisher can't publish to topic: " + topic.getTopicName());
            return;
        }
        topic.publish(message);
    }
}
