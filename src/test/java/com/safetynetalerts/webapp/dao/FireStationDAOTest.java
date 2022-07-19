package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class FireStationDAOTest {

    @Mock
    private Data data;

    @InjectMocks
    private FireStationDAO fireStationDAO;

    @Test
    public void getFireStationDAOTest(){
        FireStation fireStation = new FireStation();

        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");


        FireStation fireStation2 = new FireStation();
        fireStation2.setAddress("2bis rue du pré");
        fireStation2.setStation("20");

        Data.getFireStations().add(fireStation);
        Data.getFireStations().add(fireStation2);


        List<FireStation> list = new ArrayList<FireStation>();
        list.add(fireStation);
        list.add(fireStation2);

        assertEquals(2, list.size());

    }

    @Test
    public void saveFireStationDAOTest()  {

        FireStation fireStation = new FireStation();
        fireStationDAO = new FireStationDAO();

        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        assertTrue(fireStationDAO.saveFireStation(fireStation));
    }

    @Test
    public void deleteFireStationDAOTest(){

        //GIVEN
        FireStation fireStation = new FireStation();
        fireStationDAO = new FireStationDAO();

        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");

        Data.getFireStations().add(fireStation);

        //THEN
        assertTrue(fireStationDAO.deleteFireStation("1 Avenue de Paris"));
    }

    @Test
    public void updateFireStationDAOTest() {

        //GIVEN
        FireStation fireStation = new FireStation();
        fireStationDAO = new FireStationDAO();

        fireStation.setAddress("1 Avenue de Paris");
        fireStation.setStation("111");
        Data.getFireStations().add(fireStation);

        //THEN
        assertTrue(fireStationDAO.updateFireStation("1 Avenue de Paris", "15"));
    }

    @Test
    public void findAllFirestationsTest(){
        FireStation fireStation = new FireStation();
        Data.getFireStations().add(fireStation);

        assertTrue(fireStationDAO.findAll().contains(fireStation));
    }

    @Test
    public void getFirestationsByStationNumberTest(){
        FireStation fireStation = new FireStation("1 Avenue de Paris", "1");
        FireStation fireStation2 = new FireStation("9 rue de la Tour Eiffel","1");
        Data.getFireStations().add(fireStation);
        Data.getFireStations().add(fireStation2);

        assertEquals(2, fireStationDAO.getFirestationsByStationNumber("1").size());
    }

    @Test
    public void getFirestationsByAddressTest(){
        FireStation fireStation = new FireStation("1 Avenue de Paris", "1");
        Data.getFireStations().add(fireStation);

        assertTrue(fireStationDAO.getFirestationsByAddress("1 Avenue de Paris").contains(fireStation));
    }

    }

