
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
import tn.esprit.spring.Repository.PostRepository;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.service.PostSerivce;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import tn.esprit.spring.config.MyConstants;
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostSerivce ps;


    @Autowired
    public JavaMailSender emailSender;

    public PostController() {
    }

    @GetMapping("/getPosts")
    @ResponseBody
    public List<Post> getPosts() {
        return (List)this.ps.getPosts();
    }

    @GetMapping("/Post/{id}")
    @ResponseBody
    public Post findPost(@PathVariable("id") long idpost) {
        return (Post)this.ps.findPost(idpost);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deletePost(@PathVariable("id") long idpost) {
        this.ps.deletePost(idpost);
        System.out.println("Post deleted");
    }

    @PostMapping("/addpost")
    @ResponseBody
    public String addPost(@RequestBody Post f) {
        return this.ps.addPost(f);

    }

    @PutMapping("/updatePost")
    @ResponseBody
    public String updatePost(@RequestBody Post f) {
        return  this.ps.updatePost(f);
    }

    @PutMapping("/addpostAndaffecte/{id}")
    @ResponseBody
    public String addPostAndaffecte(@RequestBody Post p, @PathVariable("id") long id) {
        this.ps.AjouterEtAffecterPostToTopic(p, id);
        return "Post Added and Affected !!!!!";
    }

    @ResponseBody
    @PutMapping("/like/{idpost}/{idUser}")
    public String sendSimpleEmail(@PathVariable("idpost") long idpost , @PathVariable("idUser") long idUser) {


        //like a post
        //   ps.addlike(idpost,idUser);
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, vouz avez aimez cet poste merci ");

        // Send Message!
        this.emailSender.send(message);

        return "Email Sent!";
    }
}
