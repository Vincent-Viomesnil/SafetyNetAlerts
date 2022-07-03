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
        List<Person> personList = new ArrayList<>();
        FireStationDAO fireStationDAO = new FireStationDAO();
        PersonDAO personDAO = new PersonDAO();

        fireStations = fireStationDAO.getFirestationsByAddress(address);
        String firestationNumber = fireStationDAO.getFirestationByAddress(address);
        fireAddressList.setFireStation(firestationNumber);

        for (FireStation fireStation : fireStations) {
            List<Person> personList2 = personDAO.getPersonsListByAddress(fireStation.getAddress());
            personList.addAll(personList2);
                 }
        MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

        for (Person person : personList) {
             MedicalRecord medicalRecord = medicalRecordDAO.getByFirstName(person.getFirstName());
            fireAddressList.getFireAddressList().add(new FireAddressDTO(person.getFirstName(),person.getLastName(), medicalRecord.getAge(),medicalRecord.getMedications(),medicalRecord.getAllergies()));
        }

      return fireAddressList;
    }




    public List<HomeByStationNumberDTO> getHomeByStationNumber(String station) {
        List<HomeByStationNumberDTO> homeByStationNumberList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        List<FireStation> firestations = new ArrayList<FireStation>();
        FireStationDAO fireStationDAO = new FireStationDAO();
        PersonDAO personDAO = new PersonDAO();

        firestations = fireStationDAO.getFirestationsByStationNumber(station);

        for (FireStation fireStation : firestations){
            List<Person> personList2 = personDAO.getPersonsListByAddress(fireStation.getAddress());
            personList.addAll(personList2);
        }
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
        for (Person person : personList) {
            MedicalRecord medicalRecord = medicalRecordDAO.getByFirstName(person.getFirstName());
            medicalRecordList.add(medicalRecord);

            homeByStationNumberList.add(new HomeByStationNumberDTO(person.getLastName(),person.getPhone(), medicalRecord.getAge(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
        }
        return homeByStationNumberList;
    }

    public List<PersonInfoDTO> getPersonInfoList(String firstName, String lastName) {
        List<PersonInfoDTO> personInfoList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        PersonDAO personDAO = new PersonDAO();
        MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

        personList = personDAO.getPersonByFirstNameAndLastName(firstName,lastName);

        for (Person person : personList){
            MedicalRecord medicalRecord = medicalRecordDAO.getByFirstName(person.getFirstName());
            personInfoList.add(new PersonInfoDTO(person.getFirstName(),person.getLastName(),person.getAddress(),medicalRecord.getAge(),person.getEmail(),medicalRecord.getMedications(), medicalRecord.getAllergies()));
        }
        return personInfoList;
    }
}

