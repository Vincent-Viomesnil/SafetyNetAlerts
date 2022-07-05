package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailAlertDTO {

    private List<String> emailAlertList = new ArrayList<>();

    public List<String> getEmailAlertList() {
        return emailAlertList;
    }

    public void setEmailAlertList(List<String> emailAlertList) {
        this.emailAlertList = emailAlertList;
    }
}
