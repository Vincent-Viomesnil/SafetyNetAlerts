package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.repository.FireStationsRepository;

import java.util.ArrayList;
import java.util.List;

public class FireStationDAO implements FireStationsRepository {


    @Override
    public Iterable<FireStation> findAll() {
        return Data.getFireStations();
    }

    @Override
    public boolean saveFireStation(FireStation fireStation) {
        return Data.getFireStations().add(fireStation);
    }

    @Override
    public boolean deleteFireStation(String address) {
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


    public List<FireStation> getFirestationsByStationNumber(String stationNumber){
        List<FireStation> fireStationList = new ArrayList<>();

        for (FireStation fireStation : Data.getFireStations()) {

            if (fireStation.getStation().equals(stationNumber)) {
                fireStationList.add(fireStation);
            }
        }

        return fireStationList;
    }

    public List<FireStation> getFirestationsByAddress(String address){
        List<FireStation> fireStationList = new ArrayList<>();

        for (FireStation fireStation : Data.getFireStations()) {

            if (fireStation.getAddress().equals(address)) {
                fireStationList.add(fireStation);
            }
        }

        return fireStationList;
    }
    public String getAFirestationByAddress(String address){
        for (FireStation fireStation : Data.getFireStations()) {
            if (fireStation.getAddress().equals(address)) {
               return fireStation.getStation();
            }
        }

        return null;
    }

    }
