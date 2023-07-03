package tn.esprit.spring.interfaces;


import tn.esprit.spring.entities.MedicalStaff;

import java.util.List;

public interface MedicalStaffService {
    MedicalStaff saveMedicalStaff(MedicalStaff medicalStaff);
    List<MedicalStaff> getAllMedicalStaff();
    MedicalStaff getMedicalStaffById(Long medicalStaffId);
    MedicalStaff updateMedicalStaff(Long id, MedicalStaff medicalStaff);


    void deleteMedicalStaff(Long id);

}
