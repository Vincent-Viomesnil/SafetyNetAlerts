package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        public boolean addPerson(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String address,@RequestParam String city,@RequestParam String zip,@RequestParam String phone,@RequestParam String email)/*Person person*/ {
            Person person = new Person(firstName, lastName, address, city, zip, phone, email);
            return personService.addPerson(person);
          /* List<Person> newPerson = personService.addPerson(person);
           return newPerson;*/
           //paramètre à passer en plus dans postman, remettre les mêmes paramètres dans la nouvelle personne créée.
           // Il n'y avait pas besoin de recréer des objets à chaque classe puisque l'objet Person person a déjà été créé
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
