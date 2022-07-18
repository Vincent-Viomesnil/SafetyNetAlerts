package com.safetynetalerts.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.Person;
import com.safetynetalerts.webapp.service.FireStationService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class FireStationControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FireStationService fireStationService;


    @Test
    public void getFireStationTest() throws Exception {
        mockMvc.perform(get("/firestations"))
                .andExpect(status().isOk());
    }



    @Test
    public void postFireStationTest() throws Exception {

        FireStation fireStation = new FireStation("address","1");

        when(fireStationService.addFireStation(fireStation)).thenReturn(true);

        mockMvc.perform(post("/firestation?address=address&station=1")).andExpect(status().isOk());

    }


    @Test
    public void deleteFireStationTest() throws Exception {

        FireStation fireStation = new FireStation("address", "1");

        when(fireStationService.deleteFireStation("address")).thenReturn(true);

        mockMvc.perform(delete("/firestation?address=address&station=1")).andExpect(status().isOk());
    }


    @Test
    public void updateFireStationTest() throws Exception{

        FireStation fireStation = new FireStation("address", "1");

        when(fireStationService.addFireStation(fireStation)).thenReturn(true);
        mockMvc.perform(put("/firestation?address=address&station=3"))
                .andExpect(status().isOk()); //updated firestation

        verify(fireStationService,times(1)).updateFireStation("address", "3");
    }

    }



