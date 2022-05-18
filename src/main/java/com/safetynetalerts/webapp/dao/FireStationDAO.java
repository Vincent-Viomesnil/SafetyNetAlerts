package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.repository.FireStationsRepository;
import java.util.Optional;

public class FireStationDAO implements FireStationsRepository {

    @Override
    public Optional<FireStation> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<FireStation> findAll() {
        return Data.getFireStations();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public FireStation save(FireStation fireStations) {
        return null;
    }
}