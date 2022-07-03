package com.safetynetalerts.webapp.repository;

import com.safetynetalerts.webapp.dto.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlsRepository {

    List<ChildAlertDTO> getChildListByAddress(String address);

    PhoneAlertDTO getPhoneNumberListByFirestationNumber(String station);

    FireAddressListDTO getPersonsListByAddress(String address);

    List<HomeByStationNumberDTO> getHomeByStationNumber(String station);
}

