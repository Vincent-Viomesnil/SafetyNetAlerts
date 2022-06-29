package com.safetynetalerts.webapp.dto;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;

import java.util.ArrayList;
import java.util.List;

public class PersonsListByStationNumberDTO {

    private List<PersonByStationNumberDTO> personByStationNumberDTO = new ArrayList<PersonByStationNumberDTO>();
    private int mineur;
    private int majeur;
   // private MedicalRecord medicalRecord = new MedicalRecord();
  //  private AgeCalculatorService ageCalculatorService = new AgeCalculatorService();

    public List<PersonByStationNumberDTO> getPersonsByStationNumbers() {
        return personByStationNumberDTO;
    }

    public void setPersonsByStationNumbers(List<PersonByStationNumberDTO> personByStationNumberDTOS) {
        personByStationNumberDTOS = this.personByStationNumberDTO;
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
                "personsByStationNumbers=" + personByStationNumberDTO +
                ", mineur=" + mineur +
                ", majeur=" + majeur +
                '}';
    }
}
