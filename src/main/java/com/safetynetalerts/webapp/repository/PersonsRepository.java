package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonsRepository  {

    Optional<Person> findById(Long id);

    Iterable<Person> findAll();

    boolean savePerson(Person person);

    boolean deletePerson(String firstName, String lastName);
}