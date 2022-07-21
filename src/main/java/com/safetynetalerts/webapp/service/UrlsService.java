package com.safetynetalerts.webapp.service;

import com.safetynetalerts.webapp.dao.UrlsDAO;
import com.safetynetalerts.webapp.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UrlsService {

    UrlsDAO urlsDAO = new UrlsDAO();


    public PersonsListByStationNumberDTO getPersonsListsFromStationNumber(String station) {
        return urlsDAO.getPersonsListsFromStationNumber(station);
    }

    public PhoneAlertDTO getPhoneNumberListByFirestationNumber(String station) {
        return urlsDAO.getPhoneNumberListByFirestationNumber(station);
    }

    public List<ChildAlertDTO> getChildListByAddress(String address) {
        return urlsDAO.getChildListByAddress(address);
    }

    public FireAddressListDTO getPersonsListByAddress(String address) {
        return urlsDAO.getPersonsListByAddress(address);
    }

    public List<HomeByStationNumberDTO> getHomeByStationNumber(String station) {
        return urlsDAO.getHomeByStationNumber(station);
    }

    public List<PersonInfoDTO> getPersonInfoList(String firstName, String lastName) {
        return urlsDAO.getPersonInfoList(firstName,lastName);
    }

    public EmailAlertDTO getCommunityEmailList(String city) {
        return urlsDAO.getCommunityEmailList(city);
    }
}
