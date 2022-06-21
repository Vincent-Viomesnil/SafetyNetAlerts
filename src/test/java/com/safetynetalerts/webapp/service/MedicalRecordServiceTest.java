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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class MedicalRecordServiceTest {


    @MockBean
    private MedicalRecordDAO medicalRecordDAO;

    @InjectMocks
    private MedicalRecordService medicalRecordService;

    private static MedicalRecord medicalRecord;

    @Test
    public void getMedicalRecordsTest() {

        //GIVEN

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        when(medicalRecordDAO.findAll()).thenReturn(Data.getMedicalRecords());

        assertThat(medicalRecordService.getMedicalRecords()).isNotNull();

    }

    @Test
    public void addMedicalRecordTest() {

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        medicalRecordService.addMedicalRecord(medicalRecord);

        when(medicalRecordDAO.saveMedicalRecord(any(MedicalRecord.class))).thenReturn(true);

        assertThat(medicalRecordService.addMedicalRecord(medicalRecord)).isTrue();
        assertThat(medicalRecord.getBirthdate()).isEqualTo("01/01/2000");
    }


    @Test
    public void updateMedicalRecordTest() {

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        medicalRecordService.addMedicalRecord(medicalRecord);
        List<String> medications2 = List.of("dafalgan");
        List<String> allergies2 = List.of("foin");

        when(medicalRecordDAO.updateMedicalRecord("Firstname", "Lastname", "01/01/2000", medications2, allergies2)).thenReturn(true);

        assertThat(medicalRecordService.updateMedicalRecord("Firstname", "Lastname", "01/01/2000", medications2, allergies2)).isTrue();

    }

    @Test
    public void deleteFireStationTest() {

        List<String> medications = List.of("doliprane:1000mg");
        List<String> allergies = List.of("lactose");
        medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);

        medicalRecordService.addMedicalRecord(medicalRecord);

        when(medicalRecordDAO.deleteMedicalRecord("Firstname", "Lastname")).thenReturn(true);

        assertThat(medicalRecordService.deleteMedicalRecord("Firstname", "Lastname")).isTrue();
        assertThat(medicalRecordService.getMedicalRecords()).doesNotHaveToString("01/01/2000");

    }
}


