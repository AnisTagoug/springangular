package tn.esprit.spring.interfaces;


import tn.esprit.spring.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Patient savePatient(Patient patient);

    Optional<Patient> getPatient(Long id);

    List<Patient> getAllPatients();
    Patient getPatientById(Long patientId);
    void deletePatientById(Long patientId);
    Patient updatePatient(Patient patient);
}