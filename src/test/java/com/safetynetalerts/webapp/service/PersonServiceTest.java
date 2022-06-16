package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PersonServiceTest {


    @MockBean
    private PersonDAO personDAO;

    @InjectMocks
    private PersonService personService;

    private static Person person;

    @Test
    public void getPersonsTest() {

        //GIVEN
        person = new Person();

        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        when(personDAO.findAll()).thenReturn(Data.getPersons());

        assertThat(personService.getPersons()).isNotNull();

    }

    @Test
    public void addPersonTest() {

        person = new Person("first", "last", "add", "city", "zip", "phone", "email");
        personService.addPerson(person);

        when(personDAO.savePerson(any(Person.class))).thenReturn(true);

        assertThat(personService.addPerson(person)).isTrue();
        assertThat(person.getFirstName()).isEqualTo("first");
    }


    @Test
    public void updatePersonTest() {

        person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        personService.addPerson(person);

        when(personDAO.updatePerson("firstname","lastname", "add123", "city123",  "zip123", "phone123","email123")).thenReturn(true);

        assertThat(personService.updatePerson("firstname","lastname", "add123", "city123",  "zip123", "phone123","email123")).isTrue();

    }

    @Test
    public void deletePersonTest() {

        person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        personService.addPerson(person);

        when(personDAO.deletePerson("firstname", "lastname")).thenReturn(true);

        assertThat(personService.deletePerson("firstname", "lastname")).isTrue();

        assertThat(personService.getPersons()).doesNotHaveToString("firstname");


    }
}


