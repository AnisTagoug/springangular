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

public class Holiday implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idHoliday;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private Boolean isValid;

    //relation holiday&medicalStaff
    @ManyToOne
    MedicalStaff medicalStaff;

}
