package com.safetynetalerts.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String mail;

    public Person(){

    }


    public Person(String firstName, String lastName, String address, String city, String zip, String phone, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.mail = mail;
    }


    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

   public String getFirstName(){
       return firstName;
   }

    public String getLastName(){
        return lastName;
    }

    public String toString() {
       return "Person [firstName: " +getFirstName() + ", lastName: " + getLastName() + ", address: " + getAddress() + ", city: " + getCity() + ", zip: " + getZip() + ", phone: " + getPhone() + ", mail: " + getMail() +"]";
    }
    }

