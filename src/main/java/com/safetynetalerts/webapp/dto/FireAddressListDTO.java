package com.safetynetalerts.webapp.dto;

import com.safetynetalerts.webapp.model.MedicalRecord;

import java.util.ArrayList;
import java.util.List;

public class FireAddressListDTO {

    private List<FireAddressDTO> fireAddressList = new ArrayList<FireAddressDTO>();


    public List<FireAddressDTO> getFireAddressList() {
        return fireAddressList;
    }

    public void setFireAddressList(List<FireAddressDTO> fireAddressList) {
        this.fireAddressList = fireAddressList;
    }



    @Override
    public String toString() {
        return "FireAddressListDTO{" +
                "fireAddressList=" + fireAddressList +
                '}';
    }
}
