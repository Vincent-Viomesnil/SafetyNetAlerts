package com.safetynetalerts.webapp.dto;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.PersonsByStationNumber;

import java.util.ArrayList;
import java.util.List;

public class PersonsListByStationNumberDTO {

    private List<PersonsByStationNumber> personsByStationNumbers = new ArrayList<PersonsByStationNumber>();
    private int mineur;
    private int majeur;
   // private MedicalRecord medicalRecord = new MedicalRecord();
  //  private AgeCalculatorService ageCalculatorService = new AgeCalculatorService();

    public List<PersonsByStationNumber> getPersonsByStationNumbers() {
        return personsByStationNumbers;
    }

    public void setPersonsByStationNumbers(List<PersonsByStationNumber> personsByStationNumbers) {
        personsByStationNumbers = this.personsByStationNumbers;
    }


    public List<FireStation> getFirestationsByStationNumber(String stationNumber){
        List<FireStation> fireStationList = new ArrayList<>();

        for (FireStation fireStation : Data.getFireStations()) {

            if (fireStation.getStation().equals(stationNumber)) {
                fireStationList.add(fireStation);
            }
        }

        return fireStationList;
    }


//
//    public int getAgeCalculator() {
//        for (int i = 0; i < Data.getMedicalRecords().size(); i++) {
//            if (medicalRecord.getAge() > 18) {
//                majeur++;
//            } else mineur++;
//        }
//        return majeur + mineur;
//    }

//
//    public AgeCalculatorService getAgeCalculatorService() {
//        return ageCalculatorService;
//    }
//
//    public void setAgeCalculatorService(AgeCalculatorService ageCalculatorService) {
//        this.ageCalculatorService = ageCalculatorService;
//    }

    public int getMineur() {
        return mineur;
    }

    public void setMineur(int mineur) {
        this.mineur = mineur;
    }

    public int getMajeur() {
        return majeur;
    }

    public void setMajeur(int majeur) {
        this.majeur = majeur;
    }

    @Override
    public String toString() {
        return "PersonsListByStationNumberDTO{" +
                "personsByStationNumbers=" + personsByStationNumbers +
                ", mineur=" + mineur +
                ", majeur=" + majeur +
                '}';
    }
}
