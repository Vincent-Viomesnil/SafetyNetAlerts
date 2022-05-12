package com.safetynetalerts.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.PersonService;

    @RestController
    public class PersonController {

        @Autowired
        private PersonService personService;

        /**
         * Read - Get all employees
         * @return - An Iterable object of Employee full filled
         */
        @GetMapping("/persons")
        public Iterable<Person> getEmployees() {
            return personService.getPersons();
        }

    }
