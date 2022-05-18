package com.safetynetalerts.webapp.data;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Data {
    private static List<Person> persons;
    private static List<MedicalRecord> medicalrecords;
    private static List<FireStation> firestations;

    public static List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public static List<FireStation> getFireStations() {
        return firestations;
    }

    public void setFirestations(List<FireStation> firestations) {
        this.firestations = firestations;
    }

    @Override
    public String toString() {
        return "{" +
                "persons=" + persons +
                ", medicalRecords=" + medicalrecords +
                ", fireStations=" + firestations +
                '}';
    }


}


