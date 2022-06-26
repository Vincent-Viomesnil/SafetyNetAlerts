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

/*
    @Override
    public Iterable<FireStationByStationNumber> findByStationNumber(String station) {
        for (FireStation currentFireStation : Data.getFireStations()) {
            if (currentFireStation.getStation().equals(station)) {
                FireStationByStationNumber fireStationByStationNumber = new FireStationByStationNumber();
                Person person = new Person();

                if (fireStationByStationNumber.getAddress() == person.getAddress()) {

                    fireStationByStationNumber.getFirstName();
                    fireStationByStationNumber.getLastName();
                    fireStationByStationNumber.getPhone();
                    return Data.getFireStationByStationNumbers();
                }
            }
        }
        return null;
    } */

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

                    for (PersonsByStationNumber currentPersonsByStationNumber : personList.getPersonsByStationNumbers()) {
                       MedicalRecord medicalRecord = new MedicalRecord();
                        if (medicalRecord.getFirstName().equals(currentPersonsByStationNumber.getFirstName())) {
                            for (MedicalRecord currentMedicalRecord: Data.getMedicalRecords()) {
                                currentMedicalRecord.getAgeCalculator();
                            }
//                            for (int i = 0; i < personList.getPersonsByStationNumbers().size(); i++) {
//                                if (medicalRecord.getAge() > 18) {
//                                    majeur++;
//                                } else mineur++;
//                            }

                            //méthode à mettre ici
                            // pour cq person de la liste on doit récupérer les pers dans medical record. caalcul age. on incrémente boucle (int...)

                        }
                    }
                }
            }
        }


            return personList;

        }
    }
