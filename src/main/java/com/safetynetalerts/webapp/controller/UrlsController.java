package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.dto.ChildAlertDTO;
import com.safetynetalerts.webapp.dto.PersonsListByStationNumberDTO;
import com.safetynetalerts.webapp.dto.PhoneAlertDTO;
import com.safetynetalerts.webapp.service.UrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UrlsController {

    @Autowired
    private UrlsService urlsService;

    @GetMapping("/childAlert/{address}")
    public List<ChildAlertDTO> getChildListByAddress(@PathVariable String address) {
        return urlsService.getChildListByAddress(address);
    }

    @GetMapping("/phoneAlert/{station}")
    public PhoneAlertDTO getPhoneNumberByFirestationNumber(@PathVariable String station) {
        return UrlsService.getPhoneNumberListByFirestationNumber(station);
    }
}
