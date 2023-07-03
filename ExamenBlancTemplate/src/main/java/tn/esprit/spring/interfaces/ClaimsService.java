package tn.esprit.spring.interfaces;


//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.entities.Claims;
import tn.esprit.spring.entities.MedicalStaff;
import tn.esprit.spring.entities.Patient;

import java.util.List;
import java.util.Set;

public interface ClaimsService {
    Claims saveClaim(Claims claim);
    List<Claims> getAllClaims();
    Claims getClaimById(Long claimId);
    void deleteClaimById(Long claimId);

    Claims addClaim(Claims claim);

    void deleteClaim(Long id);

    Claims updateClaim(Claims claim);
    void assignPatientToClaim(Long id,Patient patient);
    void assignMedicalStaffToClaim(Long id,Set<MedicalStaff> medicalStaffSet);
}