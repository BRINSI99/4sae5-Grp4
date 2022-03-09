package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import tn.esprit.spring.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String nameTopic;

    @OneToMany(mappedBy = "topic")
    private List<Post> posts;
}
