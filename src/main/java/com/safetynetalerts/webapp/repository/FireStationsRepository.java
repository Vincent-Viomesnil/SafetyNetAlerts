package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.dto.PersonsListByStationNumberDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireStationsRepository {

    List<FireStation> findAll();

    boolean saveFireStation(FireStation fireStation);

    boolean deleteFireStation(String address);

    boolean updateFireStation(String address, String station);


    List<FireStation> getFirestationsByStationNumber(String stationNumber);

    List<FireStation> getFirestationsByAddress(String address);

    String getAFirestationByAddress(String address);
}
