package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChildAlertListByAddressDTO {

    private List<ChildAlertDTO> childAlertListDTO = new ArrayList<ChildAlertDTO>();

    public List<ChildAlertDTO> getChildAlertListDTO() {
        return childAlertListDTO;
    }

    public void setChildAlertListDTO(List<ChildAlertDTO> childAlertListDTO) {
        this.childAlertListDTO = childAlertListDTO;
    }

    @Override
    public String toString() {
        return "ChildAlertListByAddressDTO{" +
                "childAlertList=" + childAlertListDTO +
                '}';
    }
}
