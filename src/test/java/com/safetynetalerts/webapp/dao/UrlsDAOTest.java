package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.dto.*;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class UrlsDAOTest {

    @InjectMocks
    private UrlsDAO urlsDAO;

    @MockBean
    private FireStationDAO fireStationDAO;

    @MockBean
    private PersonDAO personDAO;

    @MockBean
    private MedicalRecordDAO medicalRecordDAO;

    @Test
    public void getPersonsListByStationNumberTest() throws Exception {
        urlsDAO = new UrlsDAO();
        FireStation fireStation = new FireStation();
        List<FireStation> fireStationList = new ArrayList<>();
        Person person = new Person();
        List<Person> personList = new ArrayList<>();
        fireStationDAO = new FireStationDAO();
        personDAO = new PersonDAO();

        fireStation.setAddress("address");
        fireStation.setStation("3");
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        fireStationList.add(fireStation);
        personList.add(person);

        when(fireStationDAO.getFirestationsByStationNumber(anyString())).thenReturn(fireStationList);
        when(personDAO.getPersonsListByAddress(anyString())).thenReturn(personList);

        assertNotNull(urlsDAO.getPhoneNumberListByFirestationNumber("3"));
    }

    @Test
    public void getPhoneNumberListByFirestationNumberTest() {
        urlsDAO = new UrlsDAO();
        fireStationDAO = new FireStationDAO();
        personDAO = new PersonDAO();
        FireStation fireStation = new FireStation();
        List<FireStation> fireStationList = new ArrayList<>();
        Person person = new Person();
        List<Person> personList = new ArrayList<>();

        fireStation.setAddress("address");
        fireStation.setStation("3");
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        fireStationList.add(fireStation);
        personList.add(person);

        PhoneAlertDTO phoneAlertList = new PhoneAlertDTO();
        List<String> phones = new ArrayList<>();
        phones.add("06123456789");
        phoneAlertList.setPhoneAlertList(phones);

        when(fireStationDAO.getFirestationsByStationNumber("3")).thenReturn(fireStationList);
        when(personDAO.getPersonsListByAddress("address")).thenReturn(personList);

        assertEquals(urlsDAO.getPhoneNumberListByFirestationNumber("3"), phoneAlertList);
        assertTrue(urlsDAO.getPhoneNumberListByFirestationNumber("3").getPhoneAlertList().toString().contains("06123456789"));

    }


    @Test
    public void getChildListByAddressTest(){

        urlsDAO = new UrlsDAO();
        FireStation fireStation = new FireStation();
        List<FireStation> fireStationList = new ArrayList<>();
        Person person = new Person();
        List<Person> personList = new ArrayList<>();


        fireStation.setAddress("address");
        fireStation.setStation("3");
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");
        fireStationList.add(fireStation);
        personList.add(person);

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("firstname", "lastname", "01/01/2010", medications, allergies);
        List<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();
        medicalRecordList.add(medicalRecord);
        ChildAlertDTO childAlertDTO = new ChildAlertDTO(medicalRecord.getFirstName(),medicalRecord.getLastName(),medicalRecord.getAge(),personList);
        when(personDAO.getPersonsListByAddress("address")).thenReturn(personList);
        when(medicalRecordDAO.getByFirstName("firstname")).thenReturn(medicalRecord);

        List<ChildAlertDTO> childList = new ArrayList<>();
        childList.add(childAlertDTO);

        assertTrue(urlsDAO.getChildListByAddress("address").contains(childAlertDTO));
        assertTrue(childAlertDTO.getFirstName().contains("firstname"));
        assertEquals(12, medicalRecord.getAge());

        }

    }



