package com.safetynetalerts.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.PersonService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.regex.Matcher;

import static org.assertj.core.internal.bytebuddy.implementation.FixedValue.value;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    public void testGetPerson() throws Exception {
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk());
    }

    @Test
    public void postPersonTest() throws Exception {

        Person person = new Person();
        person.setFirstName("Firstname");
        person.setLastName("Lastname");
        person.setAddress("1 avenue de France");
        person.setCity("Paris");
        person.setZip("75000");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        when(personService.addPerson(person)).thenReturn(true);
        mockMvc.perform(post("/person?firstName=Firstname&lastName=Lastname&address=1 avenue de France&city=Paris&zip=75000&phone=06123456789&email=email@email.com"))
                .andExpect(status().isOk());
             //  .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Firstname"));

       // verify(personService, times(1)).addPerson(person);
    }

    @Test
    public void updatePersonTest() throws Exception{
       /* mockMvc.perform(put("/person?firstName=Firstname&lastName=Lastname&address=1 avenue de France&city=Paris&zip=75000&phone=06123456789&email=email@email.com"))
                .andExpectAll(
                        status().isOk(), content().contentType(MediaType.APPLICATION_JSON), jsonPath("$.person.firstName").value("Firstname"));


        //when(personService.updatePerson("firstname","lastname", "address", "city",  "12345", "06123456789","email@email.com")).thenReturn(true);
        when(personService.addPerson(person)).thenReturn(true);

       // mockMvc.perform(MockMvcRequestBuilders.put("/person?firstName=firstname&lastName=lastname&address=address&city=city&zip=12345&phone=06123456789&email=email@email.com"))
             //   .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.post("/person"))
               // .content(new ObjectMapper().writeValueAsString(person))
               // .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
               // .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").exists());

        */

    }

    }


