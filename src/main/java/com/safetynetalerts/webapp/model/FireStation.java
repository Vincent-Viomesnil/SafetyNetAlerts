package com.safetynetalerts.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FireStation {

    private String address;
    private String station;

    public FireStation() {}

    public  FireStation(String address, String station) {
        this.address = address;
        this.station = station;

    }

    public String getAddress() {
        return address;
    }

    public String getStation() {
        return station;
    }

        @Override
        public String toString() {
            return "Firestation [address: " +getAddress()+ ", station: " +getStation()+"] \n";
        }
    }

