package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long codeMaterial;
    private String description;
    private Integer quantity;

    // relation material&materialUnderRepair
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MaterialUnderRepair> materialUnderRepairSet;

    // relation material&supplier
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy="material", cascade = CascadeType.ALL)
    private Set<Supplier> suppliers;

    //relation material&reservation
    @OneToMany(cascade = CascadeType.ALL, mappedBy="material")
    private Set<MaterielReservation> materielReservationSet;

}
