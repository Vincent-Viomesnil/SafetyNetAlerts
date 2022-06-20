package com.safetynetalerts.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.Period;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FireStationByStationNumber {

    private String address; //Firestation
    private String station; //Firestation

    private String postalAddress; //Person
    private String firstName; //Person
    private String lastName; //Person
    private String phone; //Person


    public FireStationByStationNumber(String address, String station, String postalAddress, String firstName, String lastName, String phone) {
        this.address = address;
        this.station = station;
        this.postalAddress = postalAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
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

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public FireStationByStationNumber() {}


    public String getAddress() {
        return address;
    }

    public String getStation() {
        return station;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "FireStationByStationNumber{" +
                "address='" + address + '\'' +
                ", station='" + station + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

