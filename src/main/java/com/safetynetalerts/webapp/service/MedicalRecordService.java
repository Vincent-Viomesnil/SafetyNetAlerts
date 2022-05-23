package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.MedicalRecordDAO;
import com.safetynetalerts.webapp.model.MedicalRecord;
import org.springframework.stereotype.Service;


@Service
public class MedicalRecordService {

    MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();


    public Iterable<MedicalRecord> getMedicalRecords() {
        return medicalRecordDAO.findAll();
    }


    public boolean addMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordDAO.saveMedicalRecord(medicalRecord);
    }

    public boolean deleteMedicalRecord(String firstName, String lastName) {
        return medicalRecordDAO.deleteMedicalRecord(firstName, lastName);
    }
}