package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynetalerts.webapp.model.FireStation;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties
public class FireAddressDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private List<String> medications;
    private List<String> allergies;
}