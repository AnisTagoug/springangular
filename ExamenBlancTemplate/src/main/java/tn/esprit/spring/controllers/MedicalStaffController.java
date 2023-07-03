package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.MedicalStaff;
import tn.esprit.spring.interfaces.MedicalStaffService;

import java.util.List;

@RestController
@RequestMapping("/medical-staff")
public class MedicalStaffController {

    @Autowired
    private MedicalStaffService medicalStaffService;

    @PostMapping
    public ResponseEntity<MedicalStaff> createMedicalStaff(@RequestBody MedicalStaff medicalStaff) {
        MedicalStaff createdMedicalStaff = medicalStaffService.saveMedicalStaff(medicalStaff);
        return new ResponseEntity<>(createdMedicalStaff, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<MedicalStaff>> getAllMedicalStaff() {
        List<MedicalStaff> medicalStaffList = medicalStaffService.getAllMedicalStaff();
        return new ResponseEntity<>(medicalStaffList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalStaff> getMedicalStaffById(@PathVariable("id") Long id) {
        MedicalStaff medicalStaff = medicalStaffService.getMedicalStaffById(id);
        return new ResponseEntity<>(medicalStaff, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalStaff> updateMedicalStaff(@PathVariable("id") Long id, @RequestBody MedicalStaff medicalStaff) {
        MedicalStaff updatedMedicalStaff = medicalStaffService.updateMedicalStaff(id, medicalStaff);
        return new ResponseEntity<>(updatedMedicalStaff, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalStaff(@PathVariable("id") Long id) {
        medicalStaffService.deleteMedicalStaff(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
