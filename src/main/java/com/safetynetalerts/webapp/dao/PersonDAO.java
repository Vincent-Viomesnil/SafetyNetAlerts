package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
@Slf4j
public class PersonDAO implements PersonsRepository {


    @Override
    public boolean savePerson(Person person) {
        return Data.getPersons().add(person);
    }

    @Override
    public List<Person> findAll() {
      return Data.getPersons();
    }


    @Override
    public boolean deletePerson(String firstName, String lastName) {
        return Data.getPersons().removeIf(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName));
    }

    @Override
    public boolean updatePerson(String firstName, String lastName, String address, String city, String zip, String phone, String email) {
        for (Person currentPerson : Data.getPersons()) {
            log.info("currentPerson:" + currentPerson);
            if (currentPerson.getFirstName().equals(firstName) && currentPerson.getLastName().equals(lastName)) {
                currentPerson.setAddress(address);
                currentPerson.setCity(city);
                currentPerson.setZip(zip);
                currentPerson.setPhone(phone);
                currentPerson.setEmail(email);

                return true;
            }
        }
                return false;
            }

    @Override
    public List<Person> getPersonsListByAddress(String address){
        List<Person> personsListByAddress = new ArrayList<>();
        for (Person person : Data.getPersons()) {
            log.info("person:" + person);
            if (person.getAddress().equals(address)) {
                personsListByAddress.add(person);
            }
        }
        return personsListByAddress;
    }

    @Override
    public List<Person> getPersonByFirstNameAndLastName(String firstName, String lastName) {
        List<Person> personList = new ArrayList<Person>();
        for (Person person : Data.getPersons()) {
            log.info("person:"  + person);
            if (person.getFirstName().equals(firstName) && (person.getLastName().equals(lastName))) {
                personList.add(person);
            }
        }
        return personList;
    }

}


