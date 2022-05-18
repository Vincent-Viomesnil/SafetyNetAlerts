package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.repository.MedicalRecordsRepository;


import java.util.Optional;

public class MedicalRecordDAO implements MedicalRecordsRepository {


    @Override
    public Optional<MedicalRecord> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<MedicalRecord> findAll() {
        return Data.getMedicalRecords();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public MedicalRecord save(MedicalRecord medicalRecords) {
        return null;
    }
}