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

public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPatient;
    private String firstName;
    private String lastName;
    private Integer age;
    private String adress;
    private Integer phone;

    //relation claims&patient
    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private Set<Claims> claimsSet;

    //relation message&patient
    @OneToMany(cascade = CascadeType.ALL, mappedBy="patient")
    private Set<Message> messageSet;

    //relation medicalfolder&patient
    @OneToOne
    private MedicalFolder medicalFolder;

    //relation appointement&patient
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Appointment> appointmentSet;




}
