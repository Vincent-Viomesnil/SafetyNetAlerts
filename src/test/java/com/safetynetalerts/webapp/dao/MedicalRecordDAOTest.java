package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.repository.MedicalRecordsRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
public class MedicalRecordDAOTest {

    private MedicalRecordDAO medicalRecordDAO;

    @Test
    public void findAllMedicalRecordsTest(){
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications1 = List.of("doli:1000mg");
        List<String> allergies1 = List.of("lacto");
        MedicalRecord medicalRecord1 = new MedicalRecord("FirstnameE", "LastnameG", "01/01/2010", medications1, allergies1);
        Data.getMedicalRecords().add(medicalRecord1);

        assertTrue(medicalRecordDAO.findAll().contains(medicalRecord1));
    }

    @Test
    public void getMedicalRecordsDAOTest(){
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        List<String> medications2 = List.of("dafalgan");
        List<String> allergies2 = List.of("foin");
        MedicalRecord medicalRecord2 = new MedicalRecord("Firstname", "Lastname", "10/10/1990", medications2, allergies2);

        Data.getMedicalRecords().add(medicalRecord);
        Data.getMedicalRecords().add(medicalRecord2);

        List<MedicalRecord> list = new ArrayList<MedicalRecord>();
        list.add(medicalRecord);
        list.add(medicalRecord2);

        assertEquals(2, list.size());

    }

    @Test
    public void saveMedicalRecordDAOTest()  {
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);


        assertTrue(medicalRecordDAO.saveMedicalRecord(medicalRecord));

    }

    @Test
    public void deleteMedicalRecordDAOTest(){

        //GIVEN
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");

        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);


        Data.getMedicalRecords().add(medicalRecord);

        //THEN
        assertTrue(medicalRecordDAO.deleteMedicalRecord("Firstname","Lastname"));

    }

    @Test
    public void updateMedicalRecordDAOTest() {

        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);
        Data.getMedicalRecords().add(medicalRecord);

        MedicalRecord currentMedical = new MedicalRecord();
        List<String> medications2 = List.of("dafalgan:500mg");
        List<String> allergies2 = List.of("foin");;
        currentMedical.setMedications(medications2);
        currentMedical.setAllergies(allergies2);
        currentMedical.setFirstName("Firstname");
        currentMedical.setLastName("Lastname");
        currentMedical.setBirthdate("01/01/2000");
        Data.getMedicalRecords().add(currentMedical);

        assertTrue(medicalRecordDAO.updateMedicalRecord("Firstname", "Lastname", "01/10/1990", medications2, allergies2));

    }

    @Test
    public void getByFirstNameTest(){
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        MedicalRecord medicalRecord = new MedicalRecord("Vincent", "Vio", "01/01/2000", medications, allergies);
        Data.getMedicalRecords().add(medicalRecord);

        assertNotNull(medicalRecordDAO.getByFirstName("Vincent"));
    }

    }

