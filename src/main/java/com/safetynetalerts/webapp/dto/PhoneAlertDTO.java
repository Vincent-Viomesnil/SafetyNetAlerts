package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneAlertDTO {

    private List<String> phoneAlertList = new ArrayList<>();

    public List<String> getPhoneAlertList() {
        return phoneAlertList;
    }

    public void setPhoneAlertList(List<String> phoneAlertList) {
        this.phoneAlertList = phoneAlertList;
    }

    @Override
    public String toString() {
        return "PhoneAlertDTO{" +
                "phoneAlertList=" + phoneAlertList +
                '}';
    }
}
