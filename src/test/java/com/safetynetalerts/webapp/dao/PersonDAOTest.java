package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PersonDAOTest {

    private static PersonDAO personDAO;

    private static Person person;

    @Test
    public void savePersonDAOTest()  {

    person = new Person();
    person.setFirstName("firstname");
    person.setLastName("lastname");
    person.setAddress("address");
    person.setCity("city");
    person.setZip("12345");
    person.setPhone("06123456789");
    person.setEmail("email@email.com");

    when(personDAO.savePerson(person)).thenReturn(true);

    assertThat(person.getFirstName()).isEqualTo("firstname");


    }


}
