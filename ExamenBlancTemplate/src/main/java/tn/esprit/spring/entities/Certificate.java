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

public class Certificate implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCertificate;
    private String studentName;
    private String domain;
    private String title;
    private LocalDate date;

    //relation certificate&medicalStaff
    @ManyToOne
    MedicalStaff mdStaff;

    //relation certificate&trainingCourse
    @ManyToOne(cascade = CascadeType.ALL)
    TrainingCourse trainingCourse;
}
