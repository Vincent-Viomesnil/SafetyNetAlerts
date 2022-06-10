package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

        Iterable<Person> iterablePerson = new ArrayList<>();

        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        when(personDAO.findAll()).thenReturn(iterablePerson);

        assertThat(iterablePerson).isNotNull();

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

    /*
        when(delete("/person?firstName=John&lastName=Boyd&address=address&city=city&zip=zip&phone=phone&email=email")).thenReturn(null);
        //Mettre les paramètres attendus dans la méthode deletePerson
        verify(personDAO, times(1)).deletePerson("John", "Boyd");
        // Si blocage, regardez autres méthodes de tests (when, then return) / créer une personne pour la supp.
  }
*/

