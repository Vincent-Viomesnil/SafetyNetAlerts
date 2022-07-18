package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.FireStationDAO;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.dto.PersonsListByStationNumberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {

    FireStationDAO fireStationDAO = new FireStationDAO();


    public List<FireStation> getFireStations() {
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