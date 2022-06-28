package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.dto.ChildAlertListByAddressDTO;
import com.safetynetalerts.webapp.model.ChildAlertDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlsRepository {

    List<ChildAlertDTO> getChildListByAddress(String address);
}
