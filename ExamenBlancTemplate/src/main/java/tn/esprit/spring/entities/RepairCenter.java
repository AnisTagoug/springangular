package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class RepairCenter implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long code;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MaterialUnderRepair> materialUnderRepairSet;



}
