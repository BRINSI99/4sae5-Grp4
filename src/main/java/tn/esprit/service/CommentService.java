
package tn.esprit.spring.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.entity.Comments;

import java.util.List;

public interface CommentsService {
    Comments addComment(Comments c);


    Comments AjouterEtAffecterCommentToPost(Comments c, long id_post);

    public List<Comments> getComments();

    public int NbreCommentsParPost(long id);
    public void deleteComments(long idComments);
    public Comments findComments( Long idComments);
    public String updateComments(@RequestBody Comments f);

}

