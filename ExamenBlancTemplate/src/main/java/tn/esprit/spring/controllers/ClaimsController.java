package tn.esprit.spring.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Claims;
import tn.esprit.spring.entities.MedicalStaff;
import tn.esprit.spring.entities.Patient;
import tn.esprit.spring.interfaces.ClaimsService;
import tn.esprit.spring.interfaces.MedicalStaffService;
import tn.esprit.spring.interfaces.PatientService;
//import tn.esprit.spring.services.ClaimsService;
//import tn.esprit.spring.services.MedicalStaffService;
//import tn.esprit.spring.services.PatientService;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/claims")
public class ClaimsController {
    @Autowired
    ClaimsService claimsService;

    @Autowired
    PatientService patientService;

    @Autowired
    MedicalStaffService medicalStaffService;

    @GetMapping("/get")
    public List<Claims> getAllClaims() {
        return claimsService.getAllClaims();
    }

    @GetMapping("/{id}")
    public Claims getClaimById(@PathVariable Long id) {
        return claimsService.getClaimById(id);
    }

    @PostMapping("")
    public Claims addClaim(@RequestBody Claims claim) {
        return claimsService.saveClaim(claim);
    }

    @PutMapping("/")
    public Claims updateClaim(@RequestBody Claims claim) {
        return claimsService.updateClaim(claim);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        claimsService.deleteClaimById(id);
    }

    @PostMapping("/{id}/patient")
    public void assignPatientToClaim(@PathVariable Long id, @RequestBody Patient patient) {
        claimsService.assignPatientToClaim(id, patient);
    }

    @PostMapping("/{id}/medicalstaff")
    public void assignMedicalStaffToClaim(@PathVariable Long id, @RequestBody Set<MedicalStaff> medicalStaffSet) {
        claimsService.assignMedicalStaffToClaim(id, medicalStaffSet);
    }
}
