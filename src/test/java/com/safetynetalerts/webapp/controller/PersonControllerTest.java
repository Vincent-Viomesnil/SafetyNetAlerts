package com.safetynetalerts.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PersonControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;


    @Test
    public void getPersonTest() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk());
    }


    @Test
    public void postPersonTest() throws Exception {

        Person person = new Person("firstname","lastname", "address", "city",  "12345", "06123456789","email@email.com");

        when(personService.addPerson(person)).thenReturn(true);

        mockMvc.perform(post("/person?firstName=firstname&lastName=lastname&address=address&city=city&zip=12345&phone=06123456789&email=email@email.com")).andExpect(status().isOk());

    }


    @Test
    public void deletePersonTest() throws Exception {

        Person person = new Person("firstname","lastname", "address", "city",  "12345", "06123456789","email@email.com");

        when(personService.deletePerson("firstname", "lastname")).thenReturn(true);

        mockMvc.perform(delete("/person?firstName=firstname&lastName=lastname")).andExpect(status().isOk());

    }


    @Test
    public void updatePersonTest() throws Exception{

        Person person = new Person();
        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        when(personService.addPerson(person)).thenReturn(true);
        mockMvc.perform(put("/person?firstName=Firstname&lastName=Lastname&address=1 avenue de France&city=Paris&zip=75000&phone=06123456789&email=email@email.com"))
                .andExpect(status().isOk()); //updated person with others parameters than firstname and lastname.

        verify(personService,times(1)).updatePerson("Firstname","Lastname", "1 avenue de France", "Paris",  "75000", "06123456789","email@email.com");

    }

    }




