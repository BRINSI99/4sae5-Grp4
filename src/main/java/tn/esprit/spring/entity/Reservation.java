package tn.esprit.spring.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "T_Reservation")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Reservation_ID")
    private long IdReservation;


    @Temporal(TemporalType.DATE)
    private Date ReservationDate;

    @ManyToOne
    TravelPlanning travels;
    @ManyToOne
    User users;








}
