package Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    private String nomMedecin;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private int telephone;
    private int prixConsultaion;

    @JsonIgnore
    @ManyToMany(mappedBy = "medecins")
    public List<Clinique> cliniques;

    @JsonIgnore
    @OneToMany(mappedBy = "medecin")
    public List<RendezVous> rendezVousList ;
}
