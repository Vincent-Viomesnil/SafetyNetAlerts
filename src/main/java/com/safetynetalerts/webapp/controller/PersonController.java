package com.safetynetalerts.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.PersonService;

    @RestController
    public class PersonController {

        @Autowired
        private PersonService personService;

        /**
         * Read - Get all employees
         * @return - An Iterable object of Persons full filled
         */
        @GetMapping("/persons")
        public Iterable<Person> getPersons() {
            return personService.getPersons();
        }

     /*   @PostMapping("/persons")
        public Iterable<Person> getPerson() {
            return personService.getPerson();
        }

        @DeleteMapping("/persons")
        public Iterable<Person> deletePersons() {
            return personService.deletePersons();*/
        }

