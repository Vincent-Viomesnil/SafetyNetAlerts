package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.FireStationDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class FireStationServiceTest {


    private FireStationDAO fireStationDAO;

    @InjectMocks
    private FireStationService fireStationService;

    private FireStation fireStation;

    @Test
    public void getFireStationsTest() {

        //GIVEN
        fireStationDAO = new FireStationDAO();
        fireStation = new FireStation();

        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        fireStationDAO.findAll();

        assertThat(fireStationService.getFireStations()).isNotNull();

    }

    @Test
    public void addPersonTest() {
        fireStationDAO = new FireStationDAO();
        fireStation = new FireStation();
        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        fireStationService.addFireStation(fireStation);

        Data.getFireStations().add(fireStation);

        assertThat(fireStationService.addFireStation(fireStation)).isTrue();
        assertThat(fireStation.getAddress()).isEqualTo("1 Avenue de Paris");
    }


    @Test
    public void updateFireStationTest() {
        fireStationDAO = new FireStationDAO();
        fireStation = new FireStation();
        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        Data.getFireStations().add(fireStation);

        assertTrue(fireStationService.updateFireStation("1 Avenue de Paris", "15"));

    }

    @Test
    public void deleteFireStationTest() {
        fireStationDAO = new FireStationDAO();
        fireStation = new FireStation();
        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        Data.getFireStations().add(fireStation);

        fireStationDAO.deleteFireStation("1 Avenue de Paris");

        assertThat(fireStationService.getFireStations()).doesNotHaveToString("1 Avenue de Paris");
    }
}


