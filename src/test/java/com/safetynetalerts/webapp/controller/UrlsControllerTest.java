package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.service.UrlsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UrlsControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPersonsListsFromStationNumberTest() throws Exception {
        mockMvc.perform(get("/firestation?station=1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getChildListByAddressTest() throws Exception {
        mockMvc.perform(get("/childAlert?address=1509 Culver St"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPhoneNumberByFirestationNumberTest() throws Exception {
        mockMvc.perform(get("/phoneAlert?station=1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPersonsListByAddressTest() throws Exception {
        mockMvc.perform(get("/fire?address=29 15th St"))
                .andExpect(status().isOk());
    }

    @Test
    public void getHomeByStationNumberTest() throws Exception {
        mockMvc.perform(get("/flood/stations?station=1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPersonInfoListTest() throws Exception {
        mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getCommunityEmailListTest() throws Exception {
        mockMvc.perform(get("/communityEmail?city=culver"))
                .andExpect(status().isOk());
    }

}