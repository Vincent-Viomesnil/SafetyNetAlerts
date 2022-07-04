package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.dto.PersonsListByStationNumberDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface FireStationsRepository {

    Iterable<FireStation> findAll();

    boolean saveFireStation(FireStation fireStation);

    boolean deleteFireStation(String address);

    boolean updateFireStation(String address, String station);



}
