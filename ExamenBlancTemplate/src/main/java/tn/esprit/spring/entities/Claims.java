package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Claims implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idClaims;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;

    //relation claims&patient
    @ManyToOne
    Patient patient;

    //relation claims&medicalstaff
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MedicalStaff> medicalStaffSet ;



}
