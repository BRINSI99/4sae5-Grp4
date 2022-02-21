package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table( name = "T_User")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Long idUser;
    @Column(name="User_FName")
    private String firstname;
    @Column(name="User_LName")
    private String lastname;
    @Column(name ="User_Email" ,nullable = false, unique = true)
    public String email;

    @JsonIgnore
    @Column(name="User_Password",nullable = false)
    public String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @ManyToOne
    Company companies;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private Set<Reservation> reservations;


}
