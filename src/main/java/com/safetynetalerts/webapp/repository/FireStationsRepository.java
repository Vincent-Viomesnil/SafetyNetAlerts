package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FireStationsRepository {

    Iterable<FireStation> findAll();

    boolean saveFireStation(FireStation fireStation);

    boolean deleteFireStation(String address);
}
