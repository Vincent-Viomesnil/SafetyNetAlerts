package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.repository.MedicalRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


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
            if (currentMedicalRecord.getFirstName().equals(firstName) && currentMedicalRecord.getLastName().equals(lastName)) {
                currentMedicalRecord.setBirthdate(birthdate);
                currentMedicalRecord.setMedications(medications);
                currentMedicalRecord.setAllergies(allergies);
                return true;
            }
        }
        return false;
    }


    public MedicalRecord getByFirstName(String firstName) {

        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
            if (medicalRecord.getFirstName().equals(firstName)) {
                return medicalRecord;
            }
        }
        return null;
    }
}