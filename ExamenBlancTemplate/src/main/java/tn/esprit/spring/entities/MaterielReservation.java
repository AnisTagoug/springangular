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

public class MaterielReservation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate date;
    private Integer quantity;

    //relation reservation&materiel
    @ManyToOne
    Material material;

    //relation reservation&medicalStaff
    @ManyToOne
    MedicalStaff medicalStaff;


}
