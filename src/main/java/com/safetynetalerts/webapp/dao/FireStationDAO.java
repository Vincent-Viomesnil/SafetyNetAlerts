package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.dto.MedicalRecordDTO;
import com.safetynetalerts.webapp.dto.PersonsListByStationNumberDTO;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.model.PersonsByStationNumber;
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


    @Override
    public PersonsListByStationNumberDTO getPersonsListsFromStationNumber(String station) {
        List<FireStation> firestations = new ArrayList<FireStation>();
        PersonsListByStationNumberDTO personList = new PersonsListByStationNumberDTO();


        firestations = personList.getFirestationsByStationNumber(station);
        //méthode qui retourne l'ensemble des firestation avec comme paramètre le numéro de station

        for (FireStation firestation : firestations) {
            for (Person person : Data.getPersons()) {
                if (firestation.getAddress().equals(person.getAddress())) {
                    PersonsByStationNumber personsByStationNumber = new PersonsByStationNumber();

                    personsByStationNumber.setFirstName(person.getFirstName());
                    personsByStationNumber.setLastName(person.getLastName());
                    personsByStationNumber.setPhone(person.getPhone());
                    personsByStationNumber.setAddress(person.getAddress());

                    personList.getPersonsByStationNumbers().add(personsByStationNumber);

                    for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {

                        if (medicalRecord.getFirstName().equals(personsByStationNumber.getFirstName())) {
                            if (medicalRecord.getAge() > 18) {
                                personList.setMajeur(personList.getMajeur()+1);
                            } else {
                                personList.setMineur(personList.getMineur()+1);
                            }
                        }
                    }
                }
            }
        }


            return personList;

        }
    }
