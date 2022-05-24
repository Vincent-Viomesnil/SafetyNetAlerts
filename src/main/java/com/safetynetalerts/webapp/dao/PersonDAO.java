package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.repository.PersonsRepository;


import java.util.Optional;

public class PersonDAO implements PersonsRepository {


    @Override
    public boolean savePerson(Person person) {
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

   /* @Override
    public boolean deletePerson(Person person) {
        return Data.getPersons().remove(person);
    }*/

    @Override
    public boolean deletePerson(String firstName, String lastName) {
        return Data.getPersons().removeIf(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName));
    }

    @Override
    public boolean updatePerson(String firstName, String lastName, String address, String city, String zip, String phone, String email) {

        for (Person currentPerson : Data.getPersons()) {
            if (currentPerson.getFirstName().equals(firstName) && currentPerson.getLastName().equals(lastName)) {
                currentPerson.setAddress(address);
                currentPerson.setCity(city);
                currentPerson.setZip(zip);
                currentPerson.setPhone(phone);
                currentPerson.setEmail(email);

                return true;
            }
        }
                return false;
            }




            //Sinon voir méthode "Collection List" pour update
        // return Data.getPersons().contains(person);


    /*    for (Person currentPerson : Data.getPersons()) {
            if ((currentPerson.getFirstName() == person.getFirstName()) && (currentPerson.getLastName() == person.getLastName())) {
                currentPerson.setAddress(person.getAddress());
                currentPerson.setCity(person.getCity());
                currentPerson.setZip(person.getZip());
                currentPerson.setPhone(person.getPhone());
                currentPerson.setEmail(person.getEmail());

                return updatePerson(currentPerson);
            }
        } return true; */
    }


