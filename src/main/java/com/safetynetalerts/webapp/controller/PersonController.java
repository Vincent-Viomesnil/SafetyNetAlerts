package com.safetynetalerts.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.PersonService;

@RestController
    public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return personService.getPersons();
    }
    //Renvoie une liste à null => méthode addPErson sauvegarde puis méthode getPersons renvoie l'objet enregistré mais pas setté donc null

    /*
    @GetMapping("/fire")
    public Iterable<PersonsByStationNumber> getPersonsByFirstname(@RequestParam String lastName) {
        return personService.getPersonsByFirstname(lastName);
    }
*/

    @PostMapping("/person")
    public boolean addPerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String city, @RequestParam String zip, @RequestParam String phone, @RequestParam String email) {
        Person person = new Person(firstName, lastName, address, city, zip, phone, email);
        return personService.addPerson(person);
          /* List<Person> newPerson = personService.addPerson(person);
           return newPerson;*/
        //paramètre à passer en plus dans postman, remettre les mêmes paramètres dans la nouvelle personne créée.
        // Il n'y avait pas besoin de recréer des objets à chaque classe puisque l'objet Person person a déjà été créé
    }

    @DeleteMapping("/person")
    public boolean deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        return personService.deletePerson(firstName, lastName);
    }

    @PutMapping("/person")
    public boolean updatePerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String city, @RequestParam String zip, @RequestParam String phone, @RequestParam String email) {
        return personService.updatePerson(firstName, lastName, address, city, zip, phone, email);
    }
}
 /* public boolean updatePerson(@RequestParam String firstName, @RequestParam String lastName) {
        personService.getPersons();
        for (Person person : personService.getPersons()) {
            if (person != null) {
                person = new Person(firstName, lastName, person.getAddress(), person.getCity(), person.getZip(), person.getPhone(), person.getEmail());
                return personService.updatePerson(person);
            } else {
                return false;
            }
        }
        return true;
    } */




   /* @DeleteMapping("/persons")
    public boolean deletePerson(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String city, @RequestParam String zip, @RequestParam String phone, @RequestParam String email) {
        Person person = new Person();
        personService.getPersons();
        if (person.getFirstName() != null && person.getLastName() != null && person.getAddress() != null && person.getCity() != null && person.getZip() != null && person.getPhone() != null  && person.getEmail() != null) {
        //if (firstName != null && lastName!= null && address != null && city != null && zip != null && phone != null  && email != null) {
        //if (firstName == person.getFirstName() && lastName == person.getLastName() && address == person.getAddress() && city == person.getCity() && zip == person.getZip() && phone == person.getPhone() && email == person.getEmail()) {
            return personService.deletePerson(person);
        } else {
            return false;
        } */
  /*  @DeleteMapping("/persons")
    public boolean deletePerson(@PathVariable String firstName) {
       return personService.deletePerson(firstName);
    }*/


