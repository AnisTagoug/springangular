package tn.esprit.spring.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.MedicalStaff;
@Repository
public interface MedicalStaffRepository extends JpaRepository<MedicalStaff, Long> {
}