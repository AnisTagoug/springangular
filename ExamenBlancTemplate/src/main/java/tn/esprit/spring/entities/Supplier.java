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

public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idSupplier;
    private String supplierName;
    private String adress;
    private Integer phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Material> material;

}
