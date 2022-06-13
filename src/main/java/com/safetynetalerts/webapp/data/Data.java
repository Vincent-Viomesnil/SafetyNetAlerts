package com.safetynetalerts.webapp.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Data {
    private static List<Person> persons = new ArrayList<Person>();
    private static List<MedicalRecord> medicalrecords= new ArrayList<MedicalRecord>();
    private static List<FireStation> firestations= new ArrayList<FireStation>();



    public static List<Person> getPersons() {
        return persons;
    }

    public static List<FireStation> getFireStations() {
        return firestations;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalrecords;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public List<FireStation> getFirestations() {
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



