package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.dto.*;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UrlsDAOTest {

    private UrlsDAO urlsDAO;

    @Autowired
    private FireStationDAO fireStationDAO;

    @Autowired
    private PersonDAO personDAO = new PersonDAO();

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;



    @Test
    public void getPersonsListByStationNumberTest() {
//        fireStationDAO = new FireStationDAO();
//        personDAO = new PersonDAO();
//        urlsDAO = new UrlsDAO();
//        Person person = new Person();
//        List<FireStation> fireStationList = new ArrayList<>();
//        List<Person> personList = new ArrayList<>();
//
//        FireStation fireStation = new FireStation("address1", "5");
//        fireStationList.add(fireStation);
//
//        person.setFirstName("first");
//        person.setLastName("name");
//        person.setAddress("address1");
//        person.setCity("city");
//        person.setZip("12345");
//        person.setPhone("06123456789");
//        person.setEmail("email@email.com");
//        Data.getPersons().add(person);
//
//        //fireStationDAO.getFirestationsByStationNumber("5");
//        //when(fireStationDAO.getFirestationsByStationNumber("5")).thenReturn(fireStationList);
//        //when(Data.getFireStations()).thenReturn(fireStationList);
//
//        PersonsListByStationNumberDTO personListDTO = new PersonsListByStationNumberDTO();
//        PersonByStationNumberDTO personByStationNumberDTO = new PersonByStationNumberDTO();
//
//        personByStationNumberDTO.setFirstName(person.getFirstName());
//        personByStationNumberDTO.setLastName(person.getLastName());
//        personByStationNumberDTO.setPhone(person.getPhone());
//        personByStationNumberDTO.setAddress(person.getAddress());
//        personListDTO.getPersonsByStationNumbers().add(personByStationNumberDTO);
//
//       // assertNotNull(urlsDAO.getPersonsListsFromStationNumber("5"));
//        assertNotNull(urlsDAO.getPersonsListsFromStationNumber("5"));
    }


    @Test
    public void getPhoneNumberListByFirestationNumberTest(){
//        urlsDAO = new UrlsDAO();
//        FireStation fireStation = new FireStation();
//        Person person = new Person();
//        fireStationDAO = new FireStationDAO();
//        personDAO = new PersonDAO();
//        PhoneAlertDTO phoneAlertDTO = new PhoneAlertDTO();
//
//        fireStation.setAddress("address");
//        fireStation.setStation("3");
//        person.setFirstName("firstname");
//        person.setLastName("lastname");
//        person.setAddress("address");
//        person.setCity("city");
//        person.setZip("12345");
//        person.setPhone("06123456789");
//        person.setEmail("email@email.com");
//        Data.getFireStations().add(fireStation);
//        Data.getPersons().add(person);
//        phoneAlertDTO.getPhoneAlertList().add(person.getPhone());
//
//        assertNotNull(urlsDAO.getPhoneNumberListByFirestationNumber("3"));
    }


    @Test
    public void getChildListByAddressTest(){
//        urlsDAO = new UrlsDAO();
//        personDAO = new PersonDAO();
//        medicalRecordDAO = new MedicalRecordDAO();
//        FireStation fireStation = new FireStation();
//        Person person = new Person();
//
//
//        fireStation.setAddress("address");
//        fireStation.setStation("3");
//        person.setFirstName("firstname");
//        person.setLastName("lastname");
//        person.setAddress("address");
//        person.setCity("city");
//        person.setZip("12345");
//        person.setPhone("06123456789");
//        person.setEmail("email@email.com");
//        Data.getFireStations().add(fireStation);
//        Data.getPersons().add(person);
//
//        List<String> medications = List.of("doliprane:1000mg");
//        List<String> allergies = List.of("lactose");
//        MedicalRecord medicalRecord = new MedicalRecord("firstname", "lastname", "01/01/2010", medications, allergies);
//        Data.getMedicalRecords().add(medicalRecord);
//        ChildAlertDTO childAlertDTO = new ChildAlertDTO(medicalRecord.getFirstName(),medicalRecord.getLastName(),medicalRecord.getAge(),List.of(person));
//        personDAO.getPersonsListByAddress("address");
//        medicalRecordDAO.getByFirstName("firstname");
//
//        List<ChildAlertDTO> childList = new ArrayList<>();
//        childList.add(childAlertDTO);
//
//        assertNotNull(urlsDAO.getChildListByAddress("address"));
//        assertTrue(childAlertDTO.getFirstName().contains("firstname"));
//        assertEquals(12, medicalRecord.getAge());
        }

    @Test
    public void getPersonsListByAddress(){
//        urlsDAO = new UrlsDAO();
//        personDAO = new PersonDAO();
//        fireStationDAO = new FireStationDAO();
//        Person person = new Person();
//        List<FireStation> fireStationList = new ArrayList<>();
//        List<Person> personList = new ArrayList<>();
//        FireAddressListDTO fireAddressList = new FireAddressListDTO();
//
//        FireStation fireStation = new FireStation("address", "4");
//        Data.getFireStations().add(fireStation);
//
//        person.setFirstName("first");
//        person.setLastName("name");
//        person.setAddress("new address");
//        person.setCity("city");
//        person.setZip("12345");
//        person.setPhone("06123456789");
//        person.setEmail("email@email.com");
//        Data.getPersons().add(person);
//
//        List<String> medications = List.of("doli:1000mg");
//        List<String> allergies = List.of("lacto");
//        MedicalRecord medicalRecord = new MedicalRecord("first","name","01/01/1999",medications, allergies);
//        Data.getMedicalRecords().add((medicalRecord));
//
//        FireAddressDTO fireAddressDTO = new FireAddressDTO(person.getFirstName(), person.getLastName(), medicalRecord.getAge(), medicalRecord.getMedications(), medicalRecord.getAllergies());
//
//        fireStationDAO.getFirestationsByStationNumber("new address");
//        personDAO.getPersonsListByAddress("new address");
//
//        fireAddressList.getFireAddressList().add(fireAddressDTO);
//
//        assertNotNull(urlsDAO.getPersonsListByAddress("new address"));
////        assertTrue(urlsDAO.getPersonsListByAddress("new address").toString().contains("firstName=first, lastName=name, address=new address1, phone=06123456789)], mineur=0, majeur=0"));
    }

    @Test
    public void getHomeByStationNumberTest(){

    }
    @Test
    public void getPersonInfoListTest(){

    }

    @Test
    public void getCommunityEmailListTest(){
//        urlsDAO = new UrlsDAO();
//        EmailAlertDTO emailAlertDTO = new EmailAlertDTO();
//        Person person = new Person();
//        person.setFirstName("Patrick");
//        person.setLastName("Dupond");
//        person.setAddress("Champs de mars");
//        person.setCity("Paris");
//        person.setZip("75000");
//        person.setPhone("012-345-678");
//        person.setEmail("patrick@email.com");
//        Data.getPersons().add(person);
//
//        List<String> phones = new ArrayList<>();
//        phones.add(person.getPhone());
//
//       // urlsDAO.getCommunityEmailList("Paris").setEmailAlertList(phones);
//
//        assertNotNull(urlsDAO.getCommunityEmailList("Paris"));
    }

    }





