package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.FireStationByStationNumber;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface FireStationsRepository {

    Iterable<FireStation> findAll();

    boolean saveFireStation(FireStation fireStation);

    boolean deleteFireStation(String address);

    boolean updateFireStation(String address, String station);

    Iterable<FireStationByStationNumber> findByStationNumber(String station);
}
