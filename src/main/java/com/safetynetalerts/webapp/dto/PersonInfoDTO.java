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
public class PersonInfoDTO {
    private String firstName;
    private String lastName;
    private String address;
    private Integer age;
    private String mail;
    private List<String> medications;
    private List<String> allergies;
}