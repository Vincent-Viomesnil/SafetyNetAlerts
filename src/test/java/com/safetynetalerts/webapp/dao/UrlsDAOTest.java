package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.dto.FireAddressDTO;
import com.safetynetalerts.webapp.dto.FireAddressListDTO;
import com.safetynetalerts.webapp.dto.PersonsListByStationNumberDTO;
import com.safetynetalerts.webapp.dto.PhoneAlertDTO;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UrlsDAOTest {

    private UrlsDAO urlsDAO;

    @Test
    public void getPhoneNumberListByFirestationNumber() {
        urlsDAO = new UrlsDAO();

        FireStation fireStation = new FireStation();
        List<FireStation> fireStationList = new ArrayList<>();
        Person person = new Person();
        PhoneAlertDTO phoneAlertList = new PhoneAlertDTO();
        FireStationDAO fireStationDAO = new FireStationDAO();

        fireStation.setAddress("1509 Culver St");
        fireStation.setStation("3");
        person.setAddress("1509 Culver St");
        person.setPhone("841-874-6512");

        phoneAlertList.getPhoneAlertList().add(person.getPhone());

        assertThat(phoneAlertList.getPhoneAlertList().contains("841-874-6512"));
    }

    @Test
    public void getPersonsListByAddress(){
//        urlsDAO = new UrlsDAO();
//
//        List<FireStation> fireStations = new ArrayList<>();
//        FireAddressListDTO fireAddressList = new FireAddressListDTO();
//        FireStationDAO fireStationDAO = new FireStationDAO();
//        Person person = new Person();
//        FireStation fireStation = new FireStation();
//        FireAddressDTO fireAddressDTO = new FireAddressDTO();
//        MedicalRecord medicalRecord = new MedicalRecord();
//
//        fireStation.setAddress("1509 Culver St");
//        person.setAddress("1509 Culver St");
//
//        fireAddressDTO.setStationAddress("1509 Culver St");
//        fireAddressDTO.setStationNumber("3");
//        fireAddressDTO.setFirstName("John");
//        fireAddressDTO.setLastName("Boyd");
//        //medicalRecordDAO.getAgeByPerson(person.getFirstName(), person.getLastName());
//        fireAddressDTO.setAge(40);
//        fireAddressDTO.setMedications(["aznol:350mg", "hydrapermazol:100mg"]);
//        fireAddressDTO.setAllergies(["nillacilan"]);
//
//        fireAddressList.getFireAddressList().add(fireAddressDTO);
//
//        assertEquals(fireAddressList.getFireAddressList().size(), 1);
    }

}
