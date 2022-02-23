package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;


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
public class Comments implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateComment;
    @ManyToOne
    private Post post;

}
