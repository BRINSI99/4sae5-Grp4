
package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.entity.Like;
import tn.esprit.spring.entity.Post;

public interface PostSerivce {
    String addPost(Post c);

    List<Post> getPosts();

    Post AjouterEtAffecterPostToTopic(Post p, long id_topic);
    public void deletePost(Long idpost);
    public Post findPost( Long idpost);
    public String updatePost(@RequestBody Post f);


    public String addlike(long idPost , long idUser);
}
