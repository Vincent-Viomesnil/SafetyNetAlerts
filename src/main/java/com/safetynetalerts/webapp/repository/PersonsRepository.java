package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonsRepository  {

    List<Person> findAll();

    boolean savePerson(Person person);

    boolean deletePerson(String firstName, String lastName);

    boolean updatePerson(String firstName, String lastName, String address, String city, String zip, String phone, String email);

}