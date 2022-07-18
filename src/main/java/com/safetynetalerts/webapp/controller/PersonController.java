package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.model.FireStation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.PersonService;

import java.util.List;

@Slf4j
@RestController
    public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> getPersons() {
        List<Person> personList = personService.getPersons();
        if (personList.isEmpty()) {
            log.error("Find all persons request FAILED");
        } else {
            log.info("Find all persons request SUCCESS");
        }
        return personList;
    }

    @PostMapping("/person")
    public boolean addPerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String city, @RequestParam String zip, @RequestParam String phone, @RequestParam String email) {
        Person person = new Person(firstName, lastName, address, city, zip, phone, email);
        log.info("Post person request SUCCESS");
        return personService.addPerson(person);
    }

    @DeleteMapping("/person")
    public boolean deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        boolean deletePerson = personService.deletePerson(firstName, lastName);
        if (deletePerson) {
            log.info("Post person request SUCCESS");
        } else {
            log.error("Post person request FAILED, the person doesn't exist, check firstName and lastName");
        }
        return deletePerson;
    }

    @PutMapping("/person")
    public boolean updatePerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String city, @RequestParam String zip, @RequestParam String phone, @RequestParam String email) {
        boolean updatePerson = personService.updatePerson(firstName, lastName, address, city, zip, phone, email);
        if (updatePerson) {
            log.info("Update person request SUCCESS");
        } else {
            log.error("Update person request FAILED, the person doesn't exist, check firstName and lastName");
        }
        return updatePerson;
    }
}
