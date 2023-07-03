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

public class Trainers implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idTrainer;
    private String name;
    private Integer phoneNumber;
    private String email;

    //relation career&trainers
    @OneToMany(cascade = CascadeType.ALL, mappedBy="trainers")
    private Set<Career> careerSet;

    //relation trainingCourse&trainers
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TrainingCourse> trainingCourseSet;

}
