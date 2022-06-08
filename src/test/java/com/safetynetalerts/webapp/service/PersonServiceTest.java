package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PersonServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonDAO personDAO;

    @MockBean
    private Person person;


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
    public void addPersonTest(){

            person = new Person("first", "last", "add", "city", "zip", "phone", "email");
            when(personDAO.savePerson(person)).thenReturn(true);
            assertThat(person.getFirstName()).isEqualTo("first");

        }


    @Test
    public void updatePersonTest() throws Exception {
        person = new Person("first", "last", "add", "city", "zip", "phone", "email");
        when(personDAO.updatePerson("first","last", "add123", "city123",  "zip123", "phone123  ","email123")).thenReturn(true);
        assertThat(person.getAddress()).isEqualTo("add123");
    }
    }

        /*
    @Test
    public void updatePersonTest() throws Exception {

      //  person = new Person("ok", "ok", "add", "city", "zip", "phone", "email");
      //  personDAO.updatePerson("ok", "ok", "ko", "ko", "ko", "ko", "ko");
       // assertThat(personService.updatePerson("ok", "ok", "ko", "ko", "ko", "ko", "ko")).isTrue();
       // mockMvc.perform(put("/person?firstName=John&lastName=Boyd&address=address&city=city&zip=zip&phone=phone&email=email"))
         //       .andExpect(status().isOk());
        person = new Person();
        PersonService personService = new PersonService();

        when(personDAO.updatePerson("firstname","lastname", "address", "city",  "12345", "06123456789","email@email.com")).thenReturn(true);

        assertTrue(personService.updatePerson("firstname","lastname", "address", "city",  "12345", "06123456789","email@email.com"));
    }


    @Test
    public void deletePersonTest() throws Exception {

        when(delete("/person?firstName=John&lastName=Boyd&address=address&city=city&zip=zip&phone=phone&email=email")).thenReturn(null);
        //Mettre les paramètres attendus dans la méthode deletePerson
        verify(personDAO, times(1)).deletePerson("John", "Boyd");
        // Si blocage, regardez autres méthodes de tests (when, then return) / créer une personne pour la supp.
  }
*/

