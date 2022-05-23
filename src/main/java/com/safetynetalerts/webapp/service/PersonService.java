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

        public boolean addPerson(Person person) {
           // personDAO.savePerson(person);
            return personDAO.savePerson(person);
        }


        //public boolean deletePerson(Person person) {
        //    return personDAO.deletePerson(person);
        //}

        public boolean deletePerson(String firstName, String lastName) {
            return personDAO.deletePerson(firstName, lastName);
        }
    }


