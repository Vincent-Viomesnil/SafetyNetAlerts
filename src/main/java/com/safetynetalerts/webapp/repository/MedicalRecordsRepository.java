package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordsRepository {

    Optional<MedicalRecord> findById(Long id);

    Iterable<MedicalRecord> findAll();

    void deleteById(Long id);

    MedicalRecord save(MedicalRecord medicalRecords);
}
