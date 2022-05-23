package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;

import java.util.List;
import java.util.Optional;

public class PersonDAO implements PersonsRepository {

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean savePerson(Person person){
       //Person newPerson = new Person("first", "last", "add", "city", "zip", "phone", "email");
         //      return savePerson(newPerson);
       /* List<Person> savePerson = null;
        savePerson.listIterator().add(new Person("first", "last", "add", "city", "zip", "phone", "email"));
        return savePerson;*/

        return Data.getPersons().add(person);
    }

    @Override
    public Iterable<Person> findAll() {
        return Data.getPersons();
    }

    @Override
    public void deleteById(Long id) {

    }

}
