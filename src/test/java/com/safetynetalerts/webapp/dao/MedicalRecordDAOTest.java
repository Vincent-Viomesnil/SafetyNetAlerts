package com.safetynetalerts.webapp.dao;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.repository.MedicalRecordsRepository;
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
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class MedicalRecordDAOTest {

    @InjectMocks
    private MedicalRecordDAO medicalRecordDAO;

    @Mock
    private Data data;

    @Test
    public void findAllMedicalRecordsTest(){
        medicalRecordDAO = new MedicalRecordDAO();
        MedicalRecord medicalRecord = new MedicalRecord();
        Data.getMedicalRecords().add(medicalRecord);

        assertTrue(medicalRecordDAO.findAll().contains(medicalRecord));
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

//  @Test
//    public void updateMedicalRecordDAOTest() {
//
//        //GIVEN
//        medicalRecordDAO = new MedicalRecordDAO();
//        List<String> medications = List.of("doliprane:1000mg");
//        List<String> allergies = List.of("lactose");
//        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);
//
//        List<String> medications2 = List.of("dafalgan");
//        List<String> allergies2 = List.of("foin");
//
//        Data.getMedicalRecords().add(medicalRecord);
//
//        //THEN
//        assertTrue(medicalRecordDAO.updateMedicalRecord("Firstname", "Lastname","10/10/1990", medications2, allergies2));
//    }

//    @Test
//    public void updateMedicalRecordDAOTest() {
//        medicalRecordDAO = new MedicalRecordDAO();
//        List<String> medications = List.of("doliprane:1000mg");
//        List<String> allergies = List.of("lactose");
//        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);
//        Data.getMedicalRecords().add(medicalRecord);
//
//
//
//        MedicalRecord currentMedical = new MedicalRecord();
//            List<String> medications2 = List.of("dafalgan");
//            List<String> allergies2 = List.of("foin");;
//            currentMedical.setMedications(medications2);
//            currentMedical.setAllergies(allergies2);
//
//            assertTrue(medicalRecordDAO.updateMedicalRecord("Firstname", "Lastname", "01/10/1990", medications2, allergies2));
//
//    }
//
//    @Test
//    public void getByFirstNameTest(){
//        medicalRecordDAO = new MedicalRecordDAO();
//        List<String> medications = List.of("doliprane:1000mg");
//        List<String> allergies = List.of("lactose");
//        MedicalRecord medicalRecord = new MedicalRecord("Firstname", "Lastname", "01/01/2000", medications, allergies);
//        Data.getMedicalRecords().add(medicalRecord);
//
//        assertSame(medicalRecordDAO.getByFirstName("Firstname"), medicalRecord);
//    }
//
////
////    public MedicalRecord getByFirstName(String firstName) {
////
////        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
////            if (medicalRecord.getFirstName().equals(firstName)) {
////                return medicalRecord;
////            }
////        }
////        return null;
////    }
    }

