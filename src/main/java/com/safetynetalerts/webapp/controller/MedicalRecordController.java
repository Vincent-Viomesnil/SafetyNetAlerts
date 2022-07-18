package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.service.MedicalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalRecord")
    public List<MedicalRecord> getMedicalRecords() {
        List<MedicalRecord> medicalRecordList = medicalRecordService.getMedicalRecords();
        if (medicalRecordList.isEmpty()) {
            log.error("Find all medicalRecords request FAILED");
        } else {
            log.info("Find all medicalRecords request SUCCESS");
        }
        return medicalRecordList ;
    }

    @PostMapping("/medicalRecord")
    public boolean addMedicalRecord(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthdate, @RequestParam List<String> medications, @RequestParam List<String> allergies) {
        MedicalRecord medicalRecord = new MedicalRecord(firstName, lastName, birthdate, medications, allergies);
        log.info("Post medicalRecord request SUCCESS");
        return medicalRecordService.addMedicalRecord(medicalRecord);
    }

    @DeleteMapping("/medicalRecord")
    public boolean deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
        boolean deleteMedicalRecord = medicalRecordService.deleteMedicalRecord(firstName, lastName);
        if (deleteMedicalRecord) {
            log.info("Delete medicalRecord request SUCCESS");
        } else {
            log.error("Delete medicalRecord request FAILED, the person doesn't exist, check firstName and lastName");
        }
        return deleteMedicalRecord;
    }

    @PutMapping("/medicalRecord")
    public boolean updateMedicalRecord(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthdate, @RequestParam List<String> medications, @RequestParam List<String> allergies) {
        boolean updateMedicalRecord = medicalRecordService.updateMedicalRecord(firstName, lastName, birthdate, medications, allergies);
        if (updateMedicalRecord) {
            log.info("Update medicalRecord request SUCCESS");
        } else {
            log.error("Update medicalRecord request FAILED, the person doesn't exist, check firstName and lastName");
        }
        return updateMedicalRecord;

    }
}
