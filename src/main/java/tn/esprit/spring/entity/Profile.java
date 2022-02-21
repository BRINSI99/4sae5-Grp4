package tn.esprit.spring.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table( name = "T_Profile")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Profile_ID")
    private Long idProfile;
    @Temporal(TemporalType.DATE)
    private Date CreationDate;

}
