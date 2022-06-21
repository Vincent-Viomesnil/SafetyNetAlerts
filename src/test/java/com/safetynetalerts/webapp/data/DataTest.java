package com.safetynetalerts.webapp.data;

import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class DataTest {

    private Data data = new Data();

    @Test
    public void listPersonTest(){

    Person person = new Person();
    List<Person> persons = new ArrayList<Person>();


        person.setFirstName("firstname");
        person.setLastName("lastname");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("12345");
        person.setPhone("06123456789");
        person.setEmail("email@email.com");

        persons.add(person);
        data.getPersons();

        assertEquals(persons.size(), 1);

}
}
