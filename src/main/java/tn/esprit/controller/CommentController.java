

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
import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.entity.Comments;
import tn.esprit.spring.service.CommentsService;

@RestController
@RequestMapping("/Comments")
public class CommentsController {
    @Autowired
    CommentsService co;



    public CommentsController() {
    }

    @GetMapping("/getComments")
    @ResponseBody
    public List<Comments> getComments() {
        return co.getComments();
    }

    @GetMapping("/Comments/{id}")
    @ResponseBody
    public Comments findComments(@PathVariable("id") Long idComments) {
        return co.findComments(idComments);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteComments(@PathVariable("id") Long idComments) {
        co.deleteComments(idComments);
    }

    @PostMapping("/addComments")
    @ResponseBody
    public String addComments(@RequestBody Comments f) {
        this.co.addComment(f);
        return "Comments Add";
    }

    @PutMapping("/updateComments")
    @ResponseBody
    public String updateComments(@RequestBody Comments f) {
        return  co.updateComments(f);

    }

    @PutMapping("/ajouterAndAffecter/{id}")
    @ResponseBody
    public String updateComments(@RequestBody Comments f, @PathVariable("id") long id) {
        this.co.AjouterEtAffecterCommentToPost(f, id);
        return "Comments added and affected !!!";
    }

    @GetMapping("/countComment/{id}")
    public int CountCommentsParPost(@PathVariable("id") long id)
    {
        return co.NbreCommentsParPost(id);
    }




}






