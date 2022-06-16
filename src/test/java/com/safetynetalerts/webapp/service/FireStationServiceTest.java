package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.FireStationDAO;
import com.safetynetalerts.webapp.dao.PersonDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class FireStationServiceTest {


    @MockBean
    private FireStationDAO fireStationDAO;

    @InjectMocks
    private FireStationService fireStationService;

    private static FireStation fireStation;

    @Test
    public void getFireStationsTest() {

        //GIVEN
        fireStation = new FireStation();

        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        when(fireStationDAO.findAll()).thenReturn(Data.getFireStations());

        assertThat(fireStationService.getFireStations()).isNotNull();

    }

    @Test
    public void addPersonTest() {

        fireStation = new FireStation();
        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        fireStationService.addFireStation(fireStation);

        when(fireStationDAO.saveFireStation(any(FireStation.class))).thenReturn(true);

        assertThat(fireStationService.addFireStation(fireStation)).isTrue();
        assertThat(fireStation.getAddress()).isEqualTo("1 Avenue de Paris");
    }


    @Test
    public void updateFireStationTest() {

        fireStation = new FireStation();
        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        fireStationService.addFireStation(fireStation);

        when(fireStationDAO.updateFireStation("2bis rue ocr", "15")).thenReturn(true);

        assertThat(fireStationService.updateFireStation("2bis rue ocr", "15")).isTrue();

    }

    @Test
    public void deleteFireStationTest() {

        fireStation = new FireStation();
        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        fireStationService.addFireStation(fireStation);

        when(fireStationDAO.deleteFireStation("1 Avenue de Paris")).thenReturn(true);

        assertThat(fireStationService.deleteFireStation("1 Avenue de Paris")).isTrue();

        assertThat(fireStationService.getFireStations()).doesNotHaveToString("1 Avenue de Paris");


    }
}


