package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.spring.entities.MedicalStaff;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.interfaces.MedicalStaffService;
import tn.esprit.spring.repositories.MedicalStaffRepository;

import java.util.List;

@Service
public class MedicalStaffServiceImpl implements MedicalStaffService {

    @Autowired
    private MedicalStaffRepository medicalStaffRepository;

    @Override
    public MedicalStaff saveMedicalStaff(MedicalStaff medicalStaff) {
        return medicalStaffRepository.save(medicalStaff);
    }

    @Override
    public List<MedicalStaff> getAllMedicalStaff() {
        return medicalStaffRepository.findAll();
    }

    @Override
    public MedicalStaff getMedicalStaffById(Long id) {
        return medicalStaffRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medical staff not found with id " + id));    }

    @Override
    public MedicalStaff updateMedicalStaff(Long id, MedicalStaff medicalStaff) {
        MedicalStaff existingMedicalStaff = medicalStaffRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medical staff not found with id " + id));
        existingMedicalStaff.setFirstName(medicalStaff.getFirstName());
        existingMedicalStaff.setLastName(medicalStaff.getLastName());
        existingMedicalStaff.setNationalIdCard(medicalStaff.getNationalIdCard());
        existingMedicalStaff.setDateOfBirth(medicalStaff.getDateOfBirth());
        existingMedicalStaff.setPhoneNumber(medicalStaff.getPhoneNumber());
        existingMedicalStaff.setEmail(medicalStaff.getEmail());
        existingMedicalStaff.setJob(medicalStaff.getJob());
        return medicalStaffRepository.save(existingMedicalStaff);
    }

    @Override
    public void deleteMedicalStaff(Long id) {
        MedicalStaff medicalStaff = medicalStaffRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medical staff not found with id " + id));
        medicalStaffRepository.delete(medicalStaff);
    }

}