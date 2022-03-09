
package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Comments;

@Repository
public interface CommentRepository extends CrudRepository<Comments, Long> {

    @Query(
            value = "SELECT count(*) FROM t_comments c WHERE c.posts_post_id=?1",
            nativeQuery = true)
    public int NbreCommentsParPost(long post_id);

}
