package com.safetynetalerts.webapp.service;

import java.util.Optional;

import com.safetynetalerts.webapp.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;

//logique métier, requête précise, fonctionnalités.

    @Service
    public class PersonService {


        private PersonsRepository personsRepository;
        PersonDAO personDAO = new PersonDAO();

        public Optional<Person> getPerson(final Long id) {
            return personsRepository.findById(id);
        }

        public Iterable<Person> getPersons() {
            return personDAO.findAll();
        }

        public void deletePersons(final Long id) {
            personsRepository.deleteById(id);
        }

        public Person savePersons(Person persons) {
            Person savedPersons = personsRepository.save(persons);
            return savedPersons;
        }

    }
