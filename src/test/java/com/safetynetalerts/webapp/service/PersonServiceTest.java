package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    private PersonDAO personDAO;

    @InjectMocks
    private PersonService personService;

    private Person person;

    @Test
    public void getPersonsTest() {

        //GIVEN
        person = new Person();
        personDAO = new PersonDAO();

        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        personDAO.findAll();

        assertThat(personService.getPersons()).isNotNull();
    }

    @Test
    public void addPersonTest() {
        person = new Person();
        personDAO = new PersonDAO();

        person.setFirstName("firstname0");
        person.setLastName("lastname0");
        person.setAddress("address0");
        person.setCity("city0");
        person.setZip("123450");
        person.setPhone("061234567890");
        person.setEmail("email@email.com0");

        Data.getPersons().add(person);


        assertTrue(personService.addPerson(person));
        assertThat(person.getFirstName()).isEqualTo("firstname0");
    }


    @Test
    public void updatePersonTest() {
        personDAO = new PersonDAO();
        person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        Data.getPersons().add(person);

        assertTrue(personService.updatePerson("firstname","lastname", "add123", "city123",  "zip123", "phone123","email123"));

    }

    @Test
    public void deletePersonTest() {
        personDAO = new PersonDAO();
        person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        Data.getPersons().add(person);

        personDAO.deletePerson("firstname", "lastname");

        assertThat(personService.getPersons()).doesNotHaveToString("firstname");


    }
}


