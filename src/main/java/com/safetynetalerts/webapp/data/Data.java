package com.safetynetalerts.webapp.data;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Component;

@Component
public class Data {
    private Person person;
    private MedicalRecord medicalRecord;
    private FireStation fireStation;


    public Person getPerson() {
        return person;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public FireStation getFireStation() {
        return fireStation;
    }

}


