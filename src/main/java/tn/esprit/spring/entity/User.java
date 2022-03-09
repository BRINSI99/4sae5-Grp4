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
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private Set<Reservation> reservations;
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public Company getCompanies() {
		return companies;
	}
	public void setCompanies(Company companies) {
		this.companies = companies;
	}
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
