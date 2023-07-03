package tn.esprit.spring.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idMessage;
    private String description;
    private LocalDate date;

    //relation message&patient
    @ManyToOne
    Patient patient;

    //relation message&medicalstaff
    @ManyToOne
    MedicalStaff medicalStaff;

}
