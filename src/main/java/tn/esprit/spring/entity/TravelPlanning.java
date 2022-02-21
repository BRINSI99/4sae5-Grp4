package tn.esprit.spring.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "T_TravelPlanning")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class TravelPlanning implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long Id;
    private String Destination;
    private int Duration;
    @Temporal(TemporalType.DATE)
    private Date StartDate;
    @Temporal(TemporalType.DATE)
    private Date EndDate;

    @Enumerated(EnumType.STRING)
    private MissionType missionType;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="travels")
    private Set<Reservation> reservations;






}
