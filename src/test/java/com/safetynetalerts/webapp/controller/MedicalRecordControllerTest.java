package com.safetynetalerts.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.service.MedicalRecordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class MedicalRecordControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalRecordService medicalRecordService;


    @Test
    public void getMedicalRecordTest() throws Exception {
        mockMvc.perform(get("/medicalRecord"))
                .andExpect(status().isOk());
    }



    @Test
    public void postMedicalRecordTest() throws Exception {

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname","Lastname", "01/01/1900", medications, allergies);

        when(medicalRecordService.addMedicalRecord(medicalRecord)).thenReturn(true);

        mockMvc.perform(post("/medicalRecord?firstName=Firstname&lastName=Lastname&birthdate=01/01/1900&medications=doliprane:1000mg&allergies=lactose")).andExpect(status().isOk());

    }


    @Test
    public void deleteMedicalRecordTest() throws Exception {

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname","Lastname", "01/01/1900", medications, allergies);

        when(medicalRecordService.deleteMedicalRecord("Firstname","Lastname")).thenReturn(true);

        mockMvc.perform(delete("/medicalRecord?firstName=Firstname&lastName=Lastname")).andExpect(status().isOk());

    }

    @Test
    public void updateMedicalRecordTest() throws Exception{
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        when(medicalRecordService.addMedicalRecord(medicalRecord)).thenReturn(true);

        List<String> medications2 = List.of("dafalgan");
        List<String> allergies2 = List.of("foin");
        mockMvc.perform(put("/medicalRecord?firstName=Nickname&lastName=Familyname&birthdate=30/12/1990&medications=dafalgan&allergies=foin"))
                .andExpect(status().isOk()); //updated medicalrecord

        verify(medicalRecordService,times(1)).updateMedicalRecord("Nickname", "Familyname", "30/12/1990", medications2, allergies2);
    }

    }


