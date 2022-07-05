package com.safetynetalerts.webapp.dto;

import com.safetynetalerts.webapp.model.FireStation;

import java.util.ArrayList;
import java.util.List;

public class FireAddressListDTO {

    private String fireStation;
    private List<FireAddressDTO> fireAddressList = new ArrayList<FireAddressDTO>();

    public String getFireStation() {
        return fireStation;
    }

    public void setFireStation(String fireStation) {
        this.fireStation = fireStation;
    }

    public List<FireAddressDTO> getFireAddressList() {
        return fireAddressList;
    }

    public void setFireAddressList(List<FireAddressDTO> fireAddressList) {
        this.fireAddressList = fireAddressList;
    }

    @Override
    public String toString() {
        return "FireAddressListDTO{" +
                "fireStation=" + fireStation +
                ", fireAddressList=" + fireAddressList +
                '}';
    }
}
