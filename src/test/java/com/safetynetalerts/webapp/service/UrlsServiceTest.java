package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.dao.UrlsDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.dto.*;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UrlsServiceTest {


    @MockBean
    private UrlsDAO urlsDAO;

    @InjectMocks
    private UrlsService urlsService;


    @Test
    public void getPersonsListsFromStationNumberTest() {

        //GIVEN
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

        when(urlsDAO.getPersonsListsFromStationNumber("2")).thenReturn(personList);

        assertThat(urlsService.getPersonsListsFromStationNumber("2")).isNotNull();

    }

    @Test
    public void getPhoneNumberListByFirestationNumberTest() {

        //GIVEN
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

        when(urlsDAO.getPhoneNumberListByFirestationNumber("2")).thenReturn(phoneAlertDTO);

        assertThat(urlsService.getPhoneNumberListByFirestationNumber("2")).isNotNull();
    }

    @Test
    public void getChildListByAddressTest() {

        //GIVEN
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

        when(urlsDAO.getChildListByAddress("address")).thenReturn(childAlertDTO);

        assertThat(urlsService.getChildListByAddress("address")).isNotNull();
    }


    @Test
    public void getPersonsListByAddressTest() {

        //GIVEN
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

        when(urlsDAO.getPersonsListByAddress("address")).thenReturn(fireAddressListDTO);

        assertThat(urlsService.getPersonsListByAddress("address")).isNotNull();
    }


    @Test
    public void getHomeByStationNumberTest() {

        //GIVEN
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

        when(urlsDAO.getHomeByStationNumber("2")).thenReturn(homeByStationNumberList);

        assertThat(urlsService.getHomeByStationNumber("2")).isNotNull();
    }


    @Test
    public void getPersonInfoListTest() {

        //GIVEN
        List<PersonInfoDTO> personInfoList = new ArrayList<>();
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

        when(urlsDAO.getPersonInfoList("firstname", "lastname")).thenReturn(personInfoList);

        assertThat(urlsService.getPersonInfoList("firstname", "lastname")).isNotNull();
    }

    @Test
    public void getCommunityEmailListTest() {

        //GIVEN
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

        when(urlsDAO.getCommunityEmailList("city")).thenReturn(emailAlertDTO);

        assertThat(urlsService.getCommunityEmailList("city")).isNotNull();
    }
}


