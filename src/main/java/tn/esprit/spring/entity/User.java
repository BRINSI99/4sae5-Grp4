
package tn.esprit.spring.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public   class User implements Serializable{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String Photo;
    private Boolean active;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch
            = FetchType.EAGER)
    private Set<Role> roles;



}
