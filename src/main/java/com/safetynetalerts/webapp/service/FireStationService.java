package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.FireStationDAO;
import com.safetynetalerts.webapp.model.FireStation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FireStationService {

    FireStationDAO fireStationDAO = new FireStationDAO();

    public Optional<FireStation> getFireStation(final Long id) {
        return fireStationDAO.findById(id);
    }

    public Iterable<FireStation> getFireStations() {
        return fireStationDAO.findAll();
    }

    public void deleteFireStation(final Long id) {
        fireStationDAO.deleteById(id);
    }

    public FireStation getFireStations(FireStation fireStations) {
        FireStation savedFireStations = fireStationDAO.save(fireStations);
        return savedFireStations;
    }
}