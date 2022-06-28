package com.safetynetalerts.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildAlertDTO { //A mettre dans DTO

        private String firstName;
        private String lastName;
        private List<Person> home = new ArrayList<>();
        private Integer age;

    public ChildAlertDTO(String firstName, String lastName, List<Person> home, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.home = home;
        this.age = age;
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

    public List<Person> getHome() {
        return home;
    }

    public void setHome(List<Person> home) {
        this.home = home;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ChildAlert{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", home=" + home +
                ", age=" + age +
                '}';
    }
}

