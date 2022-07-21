package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.repository.MedicalRecordsRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MedicalRecordDAO implements MedicalRecordsRepository {



    @Override
    public List<MedicalRecord> findAll() {
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

    @Override
    public boolean updateMedicalRecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies) {
        for (MedicalRecord currentMedicalRecord : Data.getMedicalRecords()) {
            log.info("medicalrecord:" + currentMedicalRecord);
            if (currentMedicalRecord.getFirstName().equals(firstName) && currentMedicalRecord.getLastName().equals(lastName)) {
                currentMedicalRecord.setBirthdate(birthdate);
                currentMedicalRecord.setMedications(medications);
                currentMedicalRecord.setAllergies(allergies);
                return true;
            }
        }
        return false;
    }


    @Override
    public MedicalRecord getByFirstName(String firstName) {
        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
            log.info("medicalrecord: " + medicalRecord);
            if (medicalRecord.getFirstName().equals(firstName)) {
                return medicalRecord;
            }
        }
        return null;
    }
}