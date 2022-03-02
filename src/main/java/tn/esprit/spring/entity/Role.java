package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private Long roleId;
    private String name;
    private String role;



    class User implements Serializable {

        @Id

        @GeneratedValue(strategy =
                GenerationType.AUTO)
        private int id;
        @Enumerated(EnumType.STRING)
        private RoleName role;
    }
}