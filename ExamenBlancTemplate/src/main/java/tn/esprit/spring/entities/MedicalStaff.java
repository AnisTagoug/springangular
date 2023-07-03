package tn.esprit.spring.entities;

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

public class MedicalStaff implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idStaff;
    private String firstName;
    private String lastName;
    private Integer nationalIdCard;
    private LocalDate dateOfBirth;
    private Integer phoneNumber;
    private String email;
    private String job;
    @Enumerated(EnumType.STRING)
    private Role role;

    //relation holiday&medicalStaff
    @OneToMany(cascade = CascadeType.ALL, mappedBy="medicalStaff")
    private Set<Holiday> holidaySet;

    //relation experience&medicalStaff
    @OneToMany(cascade = CascadeType.ALL, mappedBy="medStaff")
    private Set<Experience> experienceSet;

    //relation certificate&medicalStaff
    @OneToMany(cascade = CascadeType.ALL, mappedBy="mdStaff")
    private Set<Certificate> certificateSet;

    //relation career&medicalStaff
    @OneToMany(cascade = CascadeType.ALL, mappedBy="mdStaf")
    private Set<Career> careerSet;

    //relation medicalFolder&medicalStaff
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MedicalFolder> medicalFolderSet;

    //relation appoitment&medicalStaff
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Appointment> appointmentSet;

    //relation message&medicalStaff
    @OneToMany(cascade = CascadeType.ALL, mappedBy="medicalStaff")
    private Set<Message> messageSet;

    //relation reservation&medicalStaff
    @OneToMany(cascade = CascadeType.ALL, mappedBy="medicalStaff")
    private Set<MaterielReservation> materielReservationSet;


}
