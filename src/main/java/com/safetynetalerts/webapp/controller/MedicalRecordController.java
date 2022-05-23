package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.service.MedicalRecordService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalrecords")
    public Iterable<MedicalRecord> getMedicalRecords() {
        return medicalRecordService.getMedicalRecords();
    }

    @PostMapping("/medicalrecords")
    public boolean addMedicalRecord(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthDate, @RequestParam List<String> medications, @RequestParam List<String> allergies) {

        MedicalRecord medicalRecord = new MedicalRecord(firstName, lastName, birthDate, medications, allergies);
        return medicalRecordService.addMedicalRecord(medicalRecord);
    }
}
