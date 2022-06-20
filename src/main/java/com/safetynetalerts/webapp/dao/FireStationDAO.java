package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.data.UrlFirestation;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.FireStationByStationNumber;
import com.safetynetalerts.webapp.repository.FireStationsRepository;
import org.springframework.web.bind.annotation.RequestParam;

public class FireStationDAO implements FireStationsRepository {


    @Override
    public Iterable<FireStation> findAll() {
        return Data.getFireStations();
    }

    @Override
    public boolean saveFireStation(FireStation fireStation) {
      return  Data.getFireStations().add(fireStation);
    }

    @Override
    public boolean deleteFireStation(String address){
        return Data.getFireStations().removeIf(fireStation -> fireStation.getAddress().equals(address));
    }

    @Override
    public boolean updateFireStation(String address, String station) {
        for (FireStation currentFireStation : Data.getFireStations()) {
            if (currentFireStation.getAddress().equals(address)) {
                currentFireStation.setStation(station);
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<FireStationByStationNumber> findByStationNumber(String station) {
        for (FireStation currentFireStation : Data.getFireStations()) {
            if (currentFireStation.getStation().equals(station)) {
                return UrlFirestation.getByStationNumber();
            }
        }
        return null;
    }
}