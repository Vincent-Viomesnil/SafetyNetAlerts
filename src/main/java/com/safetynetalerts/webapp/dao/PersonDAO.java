package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements PersonsRepository {


    @Override
    public boolean savePerson(Person person) {
        return Data.getPersons().add(person);
    }

    @Override
    public Iterable<Person> findAll() {
      return Data.getPersons();
    }



    @Override
    public boolean deletePerson(String firstName, String lastName) {
        return Data.getPersons().removeIf(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName));
    }

    @Override
    public boolean updatePerson(String firstName, String lastName, String address, String city, String zip, String phone, String email) {
        for (Person currentPerson : Data.getPersons()) {
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

    public List<Person> getPersonsListByAddress(String address){
        List<Person> personsListByAddress = new ArrayList<>();
        for (Person person : Data.getPersons()) {
            if (person.getAddress().equals(address)) {
                personsListByAddress.add(person);
            }
        }
        return personsListByAddress;
    }

    public List<Person> getPersonByFirstNameAndLastName(String firstName, String lastName) {
        List<Person> personList = new ArrayList<Person>();
        for (Person person : Data.getPersons()) {
            if (person.getFirstName().equals(firstName) && (person.getLastName().equals(lastName))) {
                personList.add(person);
            }
        }
        return personList;
    }

}


