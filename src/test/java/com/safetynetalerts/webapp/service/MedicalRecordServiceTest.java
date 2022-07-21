package com.safetynetalerts.webapp.service;


import com.safetynetalerts.webapp.dao.FireStationDAO;
import com.safetynetalerts.webapp.dao.MedicalRecordDAO;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {


    private MedicalRecordDAO medicalRecordDAO;

    @InjectMocks
    private MedicalRecordService medicalRecordService;

    private MedicalRecord medicalRecord;

    @Test
    public void getMedicalRecordsTest() {

        //GIVEN
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        medicalRecordDAO.findAll();

        assertThat(medicalRecordService.getMedicalRecords()).isNotNull();
    }

    @Test
    public void addMedicalRecordTest() {
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        Data.getMedicalRecords().add(medicalRecord);

        assertTrue(medicalRecordService.addMedicalRecord(medicalRecord));
        assertThat(medicalRecord.getBirthdate()).isEqualTo("01/01/2000");
    }


    @Test
    public void updateMedicalRecordTest() {
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        Data.getMedicalRecords().add(medicalRecord);
        List<String> medications2 = List.of("dafalgan");
        List<String> allergies2 = List.of("foin");

        assertTrue(medicalRecordService.updateMedicalRecord("Firstname", "Lastname", "01/01/2000", medications2, allergies2));

    }

    @Test
    public void deleteFireStationTest() {
        medicalRecordDAO = new MedicalRecordDAO();
        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        Data.getMedicalRecords().add(medicalRecord);

        medicalRecordDAO.deleteMedicalRecord("Firstname","Lastname");

        assertThat(medicalRecordService.getMedicalRecords()).doesNotHaveToString("01/01/2000");
    }
}


