package com.safetynetalerts.webapp.data;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.FireStationByStationNumber;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UrlFirestation {
    private static List<Person> persons = new ArrayList<Person>();
    private static List<MedicalRecord> medicalrecords= new ArrayList<MedicalRecord>();
    private static List<FireStation> firestations= new ArrayList<FireStation>();
    private static Iterable<FireStationByStationNumber> personsListFromStationNumber = new ArrayList<FireStationByStationNumber>();


    public static List<Person> getPersons() {
        return persons;
    }

    public static List<FireStation> getFireStations() {
        return firestations;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalrecords;
    }

    public static Iterable<FireStationByStationNumber> getByStationNumber() {
        return personsListFromStationNumber;
    }

    public void setByStationNumber(List<FireStationByStationNumber> personsListFromStationNumber){
        this.personsListFromStationNumber = personsListFromStationNumber;
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
                               ", fireStations from UrlFirestation=" + firestations +
                '}';
    }
    }



