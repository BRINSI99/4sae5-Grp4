package tn.esprit.spring.entity;

import java.io.Serializable;




import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;




import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class User implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    @Column(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles = new HashSet<>();

    private boolean locked;

    private boolean enabled;
    @NonNull
    private boolean isDeleted;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;



    private Date birthDate;
    @NonNull
    private Integer age;
    @Column(name = "resettoken")
    private String resettoken;

    public boolean isEnabled() {
        return enabled;
    }
    //-----------------userDetails--------------------------











}
