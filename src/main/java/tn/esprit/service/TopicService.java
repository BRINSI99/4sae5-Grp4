
package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.entity.Topic;

public interface TopicService {
    List<Topic> listTopics();

    Topic addTopic(Topic t);

    Topic updateTopic(Topic p);

    void deleteTopic(long id);


    int nbrePostParTopic(long id);
    public Topic getTopicByid( long id);
}
