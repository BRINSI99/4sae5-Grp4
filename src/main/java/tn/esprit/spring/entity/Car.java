package tn.esprit.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String carModel;
    private String matricule;
    private String image;
    private float price;
    @Temporal(TemporalType.TIMESTAMP)
    private Date StartDateLocation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date EndDateLocation;
    private float day;
    @ManyToOne
    Employee employees;

}
