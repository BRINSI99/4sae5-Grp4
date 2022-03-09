

package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
    @Query(
            value = "SELECT count(*) FROM t_post p WHERE p.topic_id=?1",
            nativeQuery = true)
    public int NbrePostParTopic(long topic_id);


}
