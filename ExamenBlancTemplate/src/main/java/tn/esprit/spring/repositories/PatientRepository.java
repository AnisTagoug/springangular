package tn.esprit.spring.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}