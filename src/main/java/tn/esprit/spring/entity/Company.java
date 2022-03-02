package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table( name = "T_Company")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Company_ID")
    private Long idCompany;
    @Column(name = "CompanyName")
    private String name;

    @Column(name = "Company_mail", nullable = false, unique = true)
    public String email;

    @JsonIgnore
    @Column(name = "Company_Password", nullable = false)
    public String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    private Set<User> users;
}


