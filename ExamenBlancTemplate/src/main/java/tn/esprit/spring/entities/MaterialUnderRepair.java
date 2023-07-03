package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class MaterialUnderRepair implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private State state;


    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy="materialUnderRepairSet", cascade = CascadeType.ALL)
    private Set<RepairCenter> repCenter;


    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy="materialUnderRepairSet", cascade = CascadeType.ALL)
    private Set<Material> material;

}
