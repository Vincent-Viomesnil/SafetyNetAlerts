package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties
public class HomeByStationNumberDTO {
    private String lastName;
    private String phone;
    private int age;
    private List<String> medications;
    private List<String> allergies;

}