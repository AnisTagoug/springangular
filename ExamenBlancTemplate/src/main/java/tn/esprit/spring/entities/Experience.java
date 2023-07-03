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

public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idExperience;
    private String job;
    private String company;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    //relation experience&medicalStaff
    @ManyToOne
    Experience medStaff;
}
