package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.safetynetalerts.webapp.repository.PersonsRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PersonDAOTest {

    private PersonDAO personDAO;


    @Test
    public void savePersonDAOTest()  {

        Person person = new Person();
        personDAO = new PersonDAO();

    person.setFirstName("firstname");
    person.setLastName("lastname");
    person.setAddress("address");
    person.setCity("city");
    person.setZip("12345");
    person.setPhone("06123456789");
    person.setEmail("email@email.com");


    //when(personDAO.savePerson(person)).thenReturn(true);

    assertTrue(personDAO.savePerson(person));

    }

    @Test
    public void deletePersonDAOTest(){

        //GIVEN
        Person person = new Person();
        personDAO = new PersonDAO();

        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        Data.getPersons().add(person);

        //THEN
        assertTrue(personDAO.deletePerson("firstname","lastname"));

    }

    @Test
    public void updatePersonDAOTest() {

        //GIVEN
        Person person = new Person();
        personDAO = new PersonDAO();

        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        Data.getPersons().add(person);

        //THEN
        assertTrue(personDAO.updatePerson("firstname", "lastname", "add", "city123", "zip", "phone", "email"));
    }
    @Test
    public void getPersonsDAOTest(){
        Person person = new Person();
        personDAO = new PersonDAO();

        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        Person person2 = new Person();
        person2.setFirstName("first2");
        person2.setLastName("lastname2");
        person2.setAddress("address2");
        person2.setCity("city2");
        person2.setZip("123456789");
        person2.setPhone("061234567");
        person2.setEmail("email2@email.com");


        Data.getPersons().add(person);
        Data.getPersons().add(person2);

        //assertEquals(2, personDAO.findAll().spliterator().estimateSize()); =>> Comment gérer la taille  d'Iterable (méthode plus complexe).
        assertThat(personDAO.findAll()).isNotNull();


    }
}
