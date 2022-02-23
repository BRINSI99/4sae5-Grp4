package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private String content;
    private String photo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date DatePost;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Comments> comments;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Like> likes;
}
