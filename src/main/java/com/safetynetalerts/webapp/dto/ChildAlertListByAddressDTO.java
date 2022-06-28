package com.safetynetalerts.webapp.dto;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.*;

import java.util.ArrayList;
import java.util.List;

public class ChildAlertListByAddressDTO {

    private List<ChildAlertDTO> childAlertList = new ArrayList<ChildAlertDTO>(); //DTO

    public List<ChildAlertDTO> getChildAlertList() {
        return childAlertList;
    }

    public void setChildAlertList(List<ChildAlertDTO> childAlertList) {
        this.childAlertList = childAlertList;
    }

    @Override
    public String toString() {
        return "ChildAlertListByAddressDTO{" +
                "childAlertList=" + childAlertList +
                '}';
    }
}
