package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.dto.*;
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


    @GetMapping("/firestation/{station}")
    public PersonsListByStationNumberDTO getPersonsListsFromStationNumber(@PathVariable String station) {
        return urlsService.getPersonsListsFromStationNumber(station);
    }

    @GetMapping("/childAlert/{address}")
    public List<ChildAlertDTO> getChildListByAddress(@PathVariable String address) {
        return urlsService.getChildListByAddress(address);
    }

    @GetMapping("/phoneAlert/{station}")
    public PhoneAlertDTO getPhoneNumberByFirestationNumber(@PathVariable String station) {
        return urlsService.getPhoneNumberListByFirestationNumber(station);
    }

    @GetMapping("/fire/{address}")
    public FireAddressListDTO getPersonsListByAddress(@PathVariable String address) {
        return urlsService.getPersonsListByAddress(address);
    }
    @GetMapping("flood/stations/{station}")
    public List<HomeByStationNumberDTO> getHomeByStationNumber(@PathVariable String station){
        return urlsService.getHomeByStationNumber(station);
    }

    @GetMapping("personInfo/{firstName}/{lastName}")
    public List<PersonInfoDTO> getPersonInfoList(@PathVariable String firstName, @PathVariable String lastName){
        return urlsService.getPersonInfoList(firstName, lastName);
    }

    @GetMapping("/communityEmail/{city}")
    public EmailAlertDTO getCommunityEmailList(@PathVariable String city) {
        return urlsService.getCommunityEmailList(city);
    }


}
