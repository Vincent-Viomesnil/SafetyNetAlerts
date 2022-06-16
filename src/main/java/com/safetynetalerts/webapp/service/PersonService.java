package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;
import org.springframework.stereotype.Service;


    @Service
    public class PersonService {


        private PersonsRepository personsRepository;
        PersonDAO personDAO = new PersonDAO();

        public Iterable<Person> getPersons() {
            return personDAO.findAll();
        }

        public boolean addPerson(Person person) {
            return personDAO.savePerson(person);
        }

        public boolean deletePerson(String firstName, String lastName) {
            return personDAO.deletePerson(firstName, lastName);
        }

        public boolean updatePerson(String firstName, String lastName, String address, String city, String zip, String phone, String email) {
         return personDAO.updatePerson(firstName, lastName, address, city, zip, phone, email);
        }
    }


