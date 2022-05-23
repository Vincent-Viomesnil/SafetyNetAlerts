package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.repository.MedicalRecordsRepository;



public class MedicalRecordDAO implements MedicalRecordsRepository {


    @Override
    public Iterable<MedicalRecord> findAll() {
        return Data.getMedicalRecords();
    }

    @Override
    public boolean saveMedicalRecord(MedicalRecord medicalRecord) {
        return Data.getMedicalRecords().add(medicalRecord);
    }

    @Override
    public boolean deleteMedicalRecord(String firstName, String lastName) {
        return Data.getMedicalRecords().removeIf(medicalRecord -> medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName));
    }
}