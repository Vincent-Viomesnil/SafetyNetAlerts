package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.FireStationDAO;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.FireStationByStationNumber;
import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Service;

@Service
public class FireStationService {

    FireStationDAO fireStationDAO = new FireStationDAO();


    public Iterable<FireStation> getFireStations() {
        return fireStationDAO.findAll();
    }

    public boolean addFireStation(FireStation fireStation) {
        return fireStationDAO.saveFireStation(fireStation);
    }

    public boolean deleteFireStation(String address){
        return fireStationDAO.deleteFireStation(address);
    }

    public boolean updateFireStation(String address, String station) {
        return fireStationDAO.updateFireStation(address, station);
    }

    public Iterable<FireStationByStationNumber> getPersonsListFromStationNumber(String station) {
        return fireStationDAO.findByStationNumber(station);
    }

    public Iterable<Person> getPersonsListsFromStationNumber(String station) {
        return fireStationDAO.getPersonsListsFromStationNumber(station);
    }
}