package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.dao.UrlsDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.dto.*;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.apache.commons.collections.list.PredicatedList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UrlsServiceTest {

    private UrlsDAO urlsDAO;

    private PersonDAO personDAO;

    @InjectMocks
    private UrlsService urlsService;

    @Test
    public void getPersonsListsFromStationNumberTest() {

        //GIVEN
        urlsDAO = new UrlsDAO();
        PersonsListByStationNumberDTO personList = new PersonsListByStationNumberDTO();
        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        FireStation fireStation = new FireStation();
        fireStation.setStation("2");
        fireStation.setAddress("address");

        urlsDAO.getPersonsListsFromStationNumber("2");

        assertThat(urlsService.getPersonsListsFromStationNumber("2")).isNotNull();

    }

    @Test
    public void getPhoneNumberListByFirestationNumberTest() {

        //GIVEN
        urlsDAO = new UrlsDAO();
        PhoneAlertDTO phoneAlertDTO = new PhoneAlertDTO();
        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        FireStation fireStation = new FireStation();
        fireStation.setStation("2");
        fireStation.setAddress("address");

        urlsDAO.getPhoneNumberListByFirestationNumber("2");

        assertThat(urlsService.getPhoneNumberListByFirestationNumber("2")).isNotNull();
    }

    @Test
    public void getChildListByAddressTest() {

        //GIVEN
        urlsDAO = new UrlsDAO();
        List<ChildAlertDTO> childAlertDTO = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("firstname", "lastname", "01/01/2010", medications, allergies);

        urlsDAO.getChildListByAddress("address");

        assertThat(urlsService.getChildListByAddress("address")).isNotNull();
    }


    @Test
    public void getPersonsListByAddressTest() {

        //GIVEN
        urlsDAO = new UrlsDAO();
        FireAddressListDTO fireAddressListDTO = new FireAddressListDTO();
        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        FireStation fireStation = new FireStation();
        fireStation.setStation("2");
        fireStation.setAddress("address");

        urlsDAO.getPersonsListByAddress("address");

        assertThat(urlsService.getPersonsListByAddress("address")).isNotNull();
    }


    @Test
    public void getHomeByStationNumberTest() {

        //GIVEN
        urlsDAO = new UrlsDAO();
        List<HomeByStationNumberDTO> homeByStationNumberList = new ArrayList<>();
        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        FireStation fireStation = new FireStation();
        fireStation.setStation("2");
        fireStation.setAddress("address");

        urlsDAO.getHomeByStationNumber("2");

        assertThat(urlsService.getHomeByStationNumber("2")).isNotNull();
    }


    @Test
    public void getPersonInfoListTest() {
//
//        //GIVEN
//        urlsDAO = new UrlsDAO();
//        List<Person> personList = new ArrayList<>();
//        Person person = new Person();
//        person.setFirstName("firstname");
//        person.setLastName("lastname");
//        person.setAddress("address");
//        person.setCity("city");
//        person.setZip("12345");
//        person.setPhone("06123456789");
//        person.setEmail("email@email.com");
//        personList.add(person);
//
//        assertNotNull(urlsService.getPersonInfoList("firstname", "lastname"));
    }

    @Test
    public void getCommunityEmailListTest() {

        //GIVEN
        urlsDAO = new UrlsDAO();
        EmailAlertDTO emailAlertDTO = new EmailAlertDTO();
        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        FireStation fireStation = new FireStation();
        fireStation.setStation("2");
        fireStation.setAddress("address");

        urlsDAO.getCommunityEmailList("city");

        assertThat(urlsService.getCommunityEmailList("city")).isNotNull();
    }
}


