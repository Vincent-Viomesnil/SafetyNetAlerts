package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.dto.ChildAlertDTO;
import com.safetynetalerts.webapp.dto.PersonByStationNumberDTO;
import com.safetynetalerts.webapp.dto.PersonsListByStationNumberDTO;
import com.safetynetalerts.webapp.dto.PhoneAlertDTO;
import com.safetynetalerts.webapp.model.*;
import com.safetynetalerts.webapp.repository.UrlsRepository;

import java.sql.Array;
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

        firestations = personList.getFirestationsByStationNumber(station);
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
    }

