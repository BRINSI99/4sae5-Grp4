

package tn.esprit.spring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.Repository.TopicRepository;
import tn.esprit.spring.entity.Topic;
import tn.esprit.spring.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService ts;
    @Autowired
    TopicRepository tr;

    public TopicController() {
    }

    @GetMapping("/getTopic")
    @ResponseBody
    public List<Topic> getTopic() {
        return this.ts.listTopics();
    }

    @GetMapping("/getTopic/{id}")
    @ResponseBody
    public Topic getTopicByid(@PathVariable("id") long id) {
        return (Topic)this.tr.findById(id).get();
    }

    @PostMapping("/addtopic")
    @ResponseBody
    public Topic addTopic(@RequestBody Topic t) {
        return this.ts.addTopic(t);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteTopic(@PathVariable("id") long id) {
        this.ts.deleteTopic(id);
        return "Topic deleted";
    }

    @PutMapping("/updateTopic")
    @ResponseBody
    public Topic updateTopic(@RequestBody Topic t) {
        return this.ts.addTopic(t);
    }

    @GetMapping("/countPost/{id}")
    public int CountPostParTopic(@PathVariable("id") long id)
    {
        return  ts.nbrePostParTopic(id);
    }


}
