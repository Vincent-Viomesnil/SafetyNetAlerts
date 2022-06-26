package com.safetynetalerts.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynetalerts.webapp.data.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalRecord {

    private String firstName;
    private String lastName;
    private String birthdate;
    private List<String> medications;
    private List<String> allergies;
    private Integer age;
    private int mineur;
    private int majeur;


    public MedicalRecord() {
    }

    public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public List<String> getMedications() {
        return medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }


    public Integer getAge(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        age = Period.between(LocalDate.parse(this.birthdate, formatter), LocalDate.now()).getYears();
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    public int getAgeCalculator() {
        MedicalRecord medicalRecord = new MedicalRecord();

        for (int i = 0; i < Data.getMedicalRecords().size(); i++) {
            if (medicalRecord.getAge() > 18) {
                majeur++;
            } else mineur++;
        }
        return majeur + mineur;
    }


    @Override
    public String toString() {
        return "MedicalRecord [firstName: " + getFirstName() + ", lastName: " + getLastName() + ", birthdate: " + getBirthdate() + ", age :" +getAge() + ", medications: " + getMedications() + ", allergies:" + getAllergies() +"] \n";
    }
}
