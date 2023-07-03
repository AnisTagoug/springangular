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

public class Career implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCareer;
    private String speciality;
    private LocalDate startDate;
    private LocalDate endDate;
    private String university;
    private String degree;

    //relation career&medicalStaff
    @ManyToOne
    MedicalStaff mdStaf;

    //relation career&trainers
    @ManyToOne
    Trainers trainers;
}
