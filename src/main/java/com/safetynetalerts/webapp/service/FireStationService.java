package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.FireStationDAO;
import com.safetynetalerts.webapp.model.FireStation;
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
}