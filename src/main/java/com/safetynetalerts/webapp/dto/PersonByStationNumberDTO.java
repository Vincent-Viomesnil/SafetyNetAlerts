package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties
public class PersonByStationNumberDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
}


