package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.service.MedicalRecordService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalRecord")
    public Iterable<MedicalRecord> getMedicalRecords() {
        return medicalRecordService.getMedicalRecords();
    }

    @PostMapping("/medicalRecord")
    public boolean addMedicalRecord(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthDate, @RequestParam List<String> medications, @RequestParam List<String> allergies) {

        MedicalRecord medicalRecord = new MedicalRecord(firstName, lastName, birthDate, medications, allergies);
        return medicalRecordService.addMedicalRecord(medicalRecord);
    }

    @DeleteMapping("/medicalRecord")
    public boolean deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
        return medicalRecordService.deleteMedicalRecord(firstName, lastName);
    }
}
