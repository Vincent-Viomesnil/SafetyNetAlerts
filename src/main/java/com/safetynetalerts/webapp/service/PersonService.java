package com.safetynetalerts.webapp.service;

import java.util.List;
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

        public Iterable<Person> getPersons() {
            return personDAO.findAll();
        }

        public List<Person> addPerson(Person person) {
            return personDAO.savePerson(person);
        }

        public void deletePersons(final Long id) {
            personDAO.deleteById(id);
        }

    }


