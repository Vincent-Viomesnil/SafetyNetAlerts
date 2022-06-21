package com.safetynetalerts.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.Period;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FireStationByStationNumber {

    private String address; //Firestation et Person
    private String station; //Firestation
    private String firstName; //Person
    private String lastName;//Person
    private String phone;//Person



    public FireStationByStationNumber(String address, String station, String firstName, String lastName,String phone) {
        this.address = address;
        this.station = station;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        System.out.println("this is FireStationByStationNumber");

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "FireStationByStationNumber{" +
                "address='" + address + '\'' +
                ", station='" + station + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

