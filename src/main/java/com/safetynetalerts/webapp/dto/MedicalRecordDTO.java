package com.safetynetalerts.webapp.dto;

import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.MedicalRecord;
import com.safetynetalerts.webapp.model.PersonsByStationNumber;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDTO {


    private List<MedicalRecord> medicalRecordList = new ArrayList<MedicalRecord>();


    public List<MedicalRecord> getMedicalrecordsbyName(String firstName) {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {

            if (medicalRecord.getFirstName().equals(firstName)) {
                medicalRecordList.add((medicalRecord));
            }
        }

        return medicalRecordList; /// ensuite prendre cette liste pour l'utiliser avec méthode getAGE et faire la boucle dans l'autre calssseDAO ??

    }
}
