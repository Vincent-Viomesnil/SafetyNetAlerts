package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.dto.ChildAlertDTO;
import com.safetynetalerts.webapp.dto.PhoneAlertDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlsRepository {

    List<ChildAlertDTO> getChildListByAddress(String address);
     PhoneAlertDTO getPhoneNumberListByFirestationNumber(String station);
    }

