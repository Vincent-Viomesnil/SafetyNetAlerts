package com.safetynetalerts.webapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;


    @Service
    public class PersonService {

        private PersonsRepository personsRepository;

        public Optional<Person> getPerson(final Long id) {
            return personsRepository.findById(id);
        }

        public Iterable<Person> getPersons() {
            return personsRepository.findAll();
        }

        public void deletePersons(final Long id) {
            personsRepository.deleteById(id);
        }

        public Person savePersons(Person persons) {
            Person savedPersons = personsRepository.save(persons);
            return savedPersons;
        }

    }
