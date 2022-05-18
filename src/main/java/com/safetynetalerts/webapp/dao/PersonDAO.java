package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;

import java.util.Optional;

public class PersonDAO implements PersonsRepository {

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Person> findAll() {
        return Data.getPersons();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Person save(Person persons) {
        return null;
    }
}
