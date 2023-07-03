package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.spring.entities.Claims;
import tn.esprit.spring.entities.MedicalStaff;
import tn.esprit.spring.entities.Patient;
import tn.esprit.spring.interfaces.ClaimsService;
import tn.esprit.spring.repositories.ClaimsRepository;
import tn.esprit.spring.repositories.MedicalStaffRepository;
import tn.esprit.spring.repositories.PatientRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Transactional
@Service
public class ClaimsServiceImpl implements ClaimsService {

    @Autowired
    private ClaimsRepository claimsRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedicalStaffRepository medicalStaffRepository;

    @Override
    public List<Claims> getAllClaims() {
        return claimsRepository.findAll();
    }

    @Override
    public Claims getClaimById(Long id) {
        Optional<Claims> optionalClaim = claimsRepository.findById(id);
        return optionalClaim.orElse(null);
    }

    @Override
    public Claims addClaim(Claims claim) {
        if (claim.getPatient() != null && claim.getPatient().getIdPatient() != null) {
            Optional<Patient> optionalPatient = patientRepository.findById(claim.getPatient().getIdPatient());
            optionalPatient.ifPresent(claim::setPatient);
        }
        if (claim.getMedicalStaffSet() != null) {
            Set<MedicalStaff> medicalStaffSet = new HashSet<>();
            for (MedicalStaff medicalStaff : claim.getMedicalStaffSet()) {
                Optional<MedicalStaff> optionalMedicalStaff = medicalStaffRepository.findById(medicalStaff.getIdStaff());
                optionalMedicalStaff.ifPresent(medicalStaffSet::add);
            }
            claim.setMedicalStaffSet(medicalStaffSet);
        }
        return claimsRepository.save(claim);
    }
    @Override
    public Claims saveClaim(Claims claim) {
        return claimsRepository.save(claim);
    }
    @Override
    public void deleteClaimById(Long id) {
        claimsRepository.deleteById(id);
    }

    @Override
    public Claims updateClaim(Claims claim) {
        Claims existingClaim = claimsRepository.findById(claim.getIdClaims())
                .orElseThrow(() -> new NotFoundException("Claim not found with id " + claim.getIdClaims()));

        existingClaim.setDescription(claim.getDescription());
        existingClaim.setDate(claim.getDate());
        existingClaim.setPatient(claim.getPatient());

        return claimsRepository.save(existingClaim);
    }

    @Override
    public void assignPatientToClaim(Long id, Patient patient) {
        Claims existingClaim = claimsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Claim not found with id " + id));
        existingClaim.setPatient(patient);
        claimsRepository.save(existingClaim);
    }

    @Override
    public void assignMedicalStaffToClaim(Long id, Set<MedicalStaff> medicalStaffSet) {
        Claims existingClaim = claimsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Claim not found with id " + id));
        existingClaim.setMedicalStaffSet(medicalStaffSet);
        claimsRepository.save(existingClaim);
    }
    @Override
    public void deleteClaim(Long id) {
        claimsRepository.deleteById(id);
    }
}


