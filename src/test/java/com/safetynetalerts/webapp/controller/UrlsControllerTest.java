package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.service.FireStationService;
import com.safetynetalerts.webapp.service.UrlsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UrlsControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UrlsService urlsService;


    @Test
    public void getFireStationTest() throws Exception {
        mockMvc.perform(get("/firestation"))
                .andExpect(status().isOk());
    }


    }



