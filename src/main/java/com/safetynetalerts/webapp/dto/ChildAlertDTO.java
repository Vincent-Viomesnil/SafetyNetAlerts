package com.safetynetalerts.webapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.safetynetalerts.webapp.model.Person;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties
public class ChildAlertDTO {
        private String firstName;
        private String lastName;
        private Integer age;
        private List<Person> home = new ArrayList<>();
}

