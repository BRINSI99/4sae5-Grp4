
package tn.esprit.spring.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.Repository.TopicRepository;
import tn.esprit.spring.entity.Topic;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository tr;

    public TopicServiceImpl() {
    }

    public Topic addTopic(Topic t) {
        return (Topic)this.tr.save(t);
    }

    public Topic updateTopic(Topic p) {
        return (Topic)this.tr.save(p);
    }

    @Transactional
    public void deleteTopic(long id) {
        this.tr.deleteById(id);
    }


    @Override
    public List<Topic> listTopics() {
        return (List)this.tr.findAll();
    }


    @Override
    public int nbrePostParTopic(long id)
    {
        return  this.tr.NbrePostParTopic(id);
    }
    @Override
    public Topic getTopicByid( long id)
    {
        return (Topic)this.tr.findById(id).get();
    }

}
