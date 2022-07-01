package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.dto.*;
import com.safetynetalerts.webapp.model.*;
import com.safetynetalerts.webapp.repository.UrlsRepository;

import java.util.ArrayList;
import java.util.List;

public class UrlsDAO implements UrlsRepository {

    @Override
    public List<ChildAlertDTO> getChildListByAddress(String address) {

        List<Person> persons = new ArrayList<Person>();
        List<ChildAlertDTO> childList = new ArrayList<>();
        PersonDAO personDAO = new PersonDAO();

        persons = personDAO.getPersonsListByAddress(address);
        //méthode qui retourne l'ensemble des personnes en fonction de l'address

        for (Person person : persons) {
            for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
                if (person.getFirstName().equals(medicalRecord.getFirstName())) {
                    if (medicalRecord.getAge() <= 18) {
                        ChildAlertDTO childAlert = new ChildAlertDTO();

                        childAlert.setFirstName(medicalRecord.getFirstName());
                        childAlert.setLastName(medicalRecord.getLastName());
                        childAlert.setAge(medicalRecord.getAge());

                        childList.add(childAlert);

                        for (Person person2 : persons) {
                            if (person.getAddress().equals(person2.getAddress())) {
                                childAlert.getHome().add(person2);
                            }
                        }
                    }
                }
            }
        }
        return childList;

    }

    public PhoneAlertDTO getPhoneNumberListByFirestationNumber(String station) {
        List<FireStation> firestations = new ArrayList<FireStation>();
        PersonsListByStationNumberDTO personList = new PersonsListByStationNumberDTO();
        PhoneAlertDTO phoneAlertList = new PhoneAlertDTO();
        FireStationDAO fireStationDAO = new FireStationDAO();

        firestations = fireStationDAO.getFirestationsByStationNumber(station);
        //méthode qui retourne l'ensemble des firestation avec comme paramètre le numéro de station

        for (FireStation firestation : firestations) {
            for (Person person : Data.getPersons()) {
                if (firestation.getAddress().equals(person.getAddress())) {
                    phoneAlertList.getPhoneAlertList().add(person.getPhone());
                }
            }
            }
            return phoneAlertList;

    }

    @Override
    public FireAddressListDTO getPersonsListByAddress(String address) {
        List<FireStation> fireStations = new ArrayList<>();
        FireAddressListDTO fireAddressList = new FireAddressListDTO();
        FireStationDAO fireStationDAO = new FireStationDAO();

        fireStations = fireStationDAO.getFirestationsByAddress(address);

        for (FireStation fireStation : fireStations) {
            for (Person person : Data.getPersons()) {
                if (fireStation.getAddress().equals(person.getAddress())){
                    MedicalRecord medicalRecord = new MedicalRecord();
                    FireAddressDTO fireAddressDTO = new FireAddressDTO();

                    fireAddressDTO.setStationAddress(fireStation.getAddress());
                    fireAddressDTO.setStationNumber(fireStation.getStation());
                    fireAddressDTO.setFirstName(person.getFirstName());
                    fireAddressDTO.setLastName(person.getLastName());
                    fireAddressDTO.setAge(medicalRecord.getAge());
                    fireAddressDTO.setMedications(medicalRecord.getMedications());
                    fireAddressDTO.setAllergies(medicalRecord.getAllergies());

                    fireAddressList.getFireAddressList().add(fireAddressDTO);

                }
            }
        }

        return fireAddressList;

    }

    }

