package tn.esprit.spring.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table( name = "T_Post")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_ID")
    private Long id;
    @Column(name="POST_TEXT")
    private String text;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="posts")
    private Set<Comments> comments;


}
