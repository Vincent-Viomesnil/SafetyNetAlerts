package com.safetynetalerts.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.PersonService;

import java.util.List;

@RestController
    public class PersonController {

        @Autowired
        private PersonService personService;

        /**
         * Read - Get all employees
         *
         * @return - An Iterable object of Persons full filled
         */
        @GetMapping("/persons")
        public Iterable<Person> getPersons() {
            return personService.getPersons();
        }
        //Renvoie une liste à null => méthode addPErson sauvegarde puis méthode getPersons renvoie l'objet enregistré mais pas setté donc null

       @PostMapping("/persons")
        public List<Person> addPerson(Person person) {
            return personService.addPerson(person);
        }
    }
      /*  @DeleteMapping("/persons")
        public Iterable<Person> deletePersons() {
            return personService.deletePersons();
        }
    } */

    //http://localhost:8080/person
//Cet endpoint permettra d’effectuer les actions suivantes via Post/Put/Delete avec HTTP :
//● ajouter une nouvelle personne ;
//● mettre à jour une personne existante (pour le moment, supposons que le prénom et le nom de
//famille ne changent pas, mais que les autres champs peuvent être modifiés) ;
//● supprimer une personne (utilisez une combinaison de prénom et de nom comme identificateur
//unique).
