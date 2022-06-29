package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynetalerts.webapp.model.Person;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildAlertDTO {
        private String firstName;
        private String lastName;
        private Integer age;
        private List<Person> home = new ArrayList<>();

    public ChildAlertDTO(String firstName, String lastName, Integer age, List<Person> home) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.home = home;

    }

    public ChildAlertDTO(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Person> getHome() {
       return home;
    }

    public void setHome(List<Person>  home) {
        this.home = home;
    }



    @Override
    public String toString() {
        return "ChildAlert{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", home=" + home +
               '}';
    }
}

