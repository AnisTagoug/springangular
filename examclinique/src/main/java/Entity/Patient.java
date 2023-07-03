package Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String nomPatient;
    private int telephone ;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;


    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    public List<RendezVous> RDVList;
}
