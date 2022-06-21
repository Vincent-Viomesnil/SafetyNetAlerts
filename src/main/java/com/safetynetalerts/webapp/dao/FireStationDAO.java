package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.FireStationByStationNumber;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.FireStationsRepository;

public class FireStationDAO implements FireStationsRepository {


    @Override
    public Iterable<FireStation> findAll() {
        return Data.getFireStations();
    }

    @Override
    public boolean saveFireStation(FireStation fireStation) {
      return  Data.getFireStations().add(fireStation);
    }

    @Override
    public boolean deleteFireStation(String address){
        return Data.getFireStations().removeIf(fireStation -> fireStation.getAddress().equals(address));
    }

    @Override
    public boolean updateFireStation(String address, String station) {
        for (FireStation currentFireStation : Data.getFireStations()) {
            if (currentFireStation.getAddress().equals(address)) {
                currentFireStation.setStation(station);
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<FireStationByStationNumber> findByStationNumber(String station) {
        for (FireStation currentFireStation : Data.getFireStations()) {
            if (currentFireStation.getStation().equals(station)) {
                FireStationByStationNumber fireStationByStationNumber = new FireStationByStationNumber();
                Person person = new Person();

                if (fireStationByStationNumber.getAddress() == person.getAddress()) {

                    fireStationByStationNumber.getFirstName();
                    fireStationByStationNumber.getLastName();
                    fireStationByStationNumber.getPhone();
                    return Data.getFireStationByStationNumbers();
                }
            }
        }
        return null;
    }

    public Iterable<Person> getPersonsListsFromStationNumber(String station) {
        Person person = new Person();

        for (FireStation currentFireStation : Data.getFireStations()) {
            if (currentFireStation.getStation().equals(station)) {
                currentFireStation.getStation();
                person.getFirstName();
                person.getLastName();
                person.getAddress();
                person.getPhone();
              }

            }
        return null;
    }
}