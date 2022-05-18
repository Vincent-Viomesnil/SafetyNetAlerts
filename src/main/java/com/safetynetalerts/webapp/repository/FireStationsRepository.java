package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FireStationsRepository {


    Optional<FireStation> findById(Long id);

    Iterable<FireStation> findAll();

    void deleteById(Long id);

    FireStation save(FireStation fireStations);
}

