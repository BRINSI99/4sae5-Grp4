package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table( name = "T_Message")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="Message_ID")
    private long IdMessage;
    @Column(name="text_ID")
    private String Text;
    @Temporal(TemporalType.DATE)
    private Date Date;





}
