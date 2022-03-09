
package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.Repository.PostRepository;
import tn.esprit.spring.entity.Comments;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.config.BadWordFilter;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    CommentRepository cp;
    @Autowired
    PostRepository pr;
    BadWordFilter b= new BadWordFilter();

    public CommentsServiceImpl() {
    }

    public Comments addComment(Comments c) {

        String output=b.getCensoredText(c.getContent());
        System.out.println(output);
        c.setContent(output);
        this.cp.save(c);
        return (c);
    }


    public Comments AjouterEtAffecterCommentToPost(Comments c, long id_post) {
        Post p = (Post) this.pr.findById(id_post).get();
        c.setPost(p);
        return (Comments) this.cp.save(c);
    }

    @Override
    public List<Comments> getComments() {
        return (List) this.cp.findAll();
    }

    @Override
    public int NbreCommentsParPost(long id) {
        return cp.NbreCommentsParPost(id);
    }

    @Override
    public void deleteComments(long idComments) {

        this.cp.deleteById(idComments);
        System.out.println("Comment deleted");

    }

    @Override
    public Comments findComments(Long idComments)

    {
        return cp.findById(idComments).orElse(null);

    }
    @Override
    public String updateComments(@RequestBody Comments f)
    {
        // Comments comments = (Comments)this.co(f.getId()).orElse(null);
        this.cp.save(f);
        return "Comments update";
    }
}


