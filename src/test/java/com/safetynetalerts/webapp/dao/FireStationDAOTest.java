package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class FireStationDAOTest {

    private FireStationDAO fireStationDAO;

    @Test
    public void getPersonsDAOTest(){
        FireStation fireStation = new FireStation();
        fireStationDAO = new FireStationDAO();

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

    }

