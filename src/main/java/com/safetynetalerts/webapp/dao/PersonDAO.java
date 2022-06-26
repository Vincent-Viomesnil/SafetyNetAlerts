package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.PersonsByStationNumber;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;

import java.util.List;
import java.util.stream.Collectors;

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
 /*
    public Iterable<PersonsByStationNumber> getPersonsByFirstname(String lastName) {
        List<PersonsByStationNumber> personListByFirstname = Data.getFireStationByStationNumbers().stream()
                .filter(person -> person.getLastName().equals(lastName))
               // .map(person -> person.getFirstName().
                .collect(Collectors.toList());

        return personListByFirstname;
    }


     */
}


