package tn.esprit.spring.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "Invitations")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invitations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idInvitation;
    @Temporal(TemporalType.DATE)
    private Date dateInvitation;
    @Enumerated(EnumType.STRING)
    private Status status;
}
