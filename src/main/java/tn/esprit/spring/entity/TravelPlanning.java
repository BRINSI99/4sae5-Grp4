package tn.esprit.spring.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "T_TravelPlanning")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class TravelPlanning implements Serializable {

    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name="Destination")
    private String Destination;
    @Column(name="Duration")
    private int Duration;
    @Temporal(TemporalType.DATE)
    private Date StartDate;
    @Temporal(TemporalType.DATE)
    private Date EndDate;
    @Column(name="likes")
    private int likes;
    @Column(name="share")
    private int share;
    @Enumerated(EnumType.STRING)
    private MissionType missionType;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="travels")
    private Set<Reservation> reservations;






}
