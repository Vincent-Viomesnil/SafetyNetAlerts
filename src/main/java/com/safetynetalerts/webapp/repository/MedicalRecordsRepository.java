package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordsRepository {

     Iterable<MedicalRecord> findAll();

    boolean saveMedicalRecord(MedicalRecord medicalRecord);

    boolean deleteMedicalRecord(String firstName, String lastName);
}