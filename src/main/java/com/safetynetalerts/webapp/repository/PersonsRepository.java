package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonsRepository  {

    Iterable<Person> findAll();

   // Iterable<PersonsByStationNumber> getPersonsByFirstname(String lastName);

    boolean savePerson(Person person);

    boolean deletePerson(String firstName, String lastName);

    boolean updatePerson(String firstName, String lastName, String address, String city, String zip, String phone, String email);

}