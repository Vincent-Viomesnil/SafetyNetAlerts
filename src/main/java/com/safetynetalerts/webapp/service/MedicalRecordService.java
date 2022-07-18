package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.MedicalRecordDAO;
import com.safetynetalerts.webapp.model.MedicalRecord;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MedicalRecordService {

    MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();


    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecordDAO.findAll();
    }


    public boolean addMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordDAO.saveMedicalRecord(medicalRecord);
    }

    public boolean deleteMedicalRecord(String firstName, String lastName) {
        return medicalRecordDAO.deleteMedicalRecord(firstName, lastName);
    }

    public boolean updateMedicalRecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies) {
        return medicalRecordDAO.updateMedicalRecord(firstName, lastName, birthdate, medications, allergies);
    }
}