package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.MedicalRecordDAO;
import com.safetynetalerts.webapp.model.MedicalRecord;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalRecordService {

    MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    public Optional<MedicalRecord> getMedicalRecord(final long id) {
        return medicalRecordDAO.findById(id);
    }

    public Iterable<MedicalRecord> getMedicalRecords() {
        return medicalRecordDAO.findAll();
    }

    public void deleteMedicalRecords(final Long id) {
        medicalRecordDAO.deleteById(id);
    }

    public MedicalRecord saveMedicalRecords(MedicalRecord medicalRecords) {
        MedicalRecord savedMedicalRecords = medicalRecordDAO.save(medicalRecords);
        return savedMedicalRecords;
    }

}