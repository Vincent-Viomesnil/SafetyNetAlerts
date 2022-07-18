package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.dto.*;
import com.safetynetalerts.webapp.service.UrlsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UrlsController {

    @Autowired
    private UrlsService urlsService;


    @GetMapping("/firestation/{station}")
    public PersonsListByStationNumberDTO getPersonsListsFromStationNumber(@PathVariable String station) {
        PersonsListByStationNumberDTO personsListByStationNumberDTO = urlsService.getPersonsListsFromStationNumber(station);
        if (personsListByStationNumberDTO.getPersonsByStationNumbers().isEmpty()) {
            log.error("Find all person by station number request FAILED");
        } else {
            log.info("Find all persons by station number request SUCCESS");
        }
        return personsListByStationNumberDTO;
    }

    @GetMapping("/childAlert/{address}")
    public List<ChildAlertDTO> getChildListByAddress(@PathVariable String address) {
        List<ChildAlertDTO> childAlertDTOList = urlsService.getChildListByAddress(address);
        if (childAlertDTOList.isEmpty()) {
            log.error("Find all child by home request FAILED, address not found or no child found at this address");
        } else {
            log.info("Find all child by home request SUCCESS");
        }
        return childAlertDTOList;
    }


    @GetMapping("/phoneAlert/{station}")
    public PhoneAlertDTO getPhoneNumberByFirestationNumber(@PathVariable String station) {
        PhoneAlertDTO phoneAlertDTO = urlsService.getPhoneNumberListByFirestationNumber(station);
        if (phoneAlertDTO.getPhoneAlertList().isEmpty()){
            log.error("Find all phone number by firestation number request FAILED, station number not found");
        } else {
            log.info("Find all phone number by firestation number request SUCCESS");
        }
        return phoneAlertDTO;
    }

    @GetMapping("/fire/{address}")
    public FireAddressListDTO getPersonsListByAddress(@PathVariable String address) {
        FireAddressListDTO fireAddressListDTO = urlsService.getPersonsListByAddress(address);
        if (fireAddressListDTO.getFireAddressList().isEmpty()){
            log.error("Find person by address' firestation request FAILED, address not found");
        } else {
            log.info("Find person by address' firestation request SUCCESS");
        }
        return fireAddressListDTO;
    }

    @GetMapping("flood/stations/{station}")
    public List<HomeByStationNumberDTO> getHomeByStationNumber(@PathVariable String station){
        List<HomeByStationNumberDTO> homeByStationNumberDTOList = urlsService.getHomeByStationNumber(station);
        if (homeByStationNumberDTOList.isEmpty()){
            log.error("Find homes by firestation number request FAILED, station number doesn't exist");
        } else {
            log.info("Find homes by firestation number request SUCCESS");
        }
        return homeByStationNumberDTOList;
    }

    @GetMapping("personInfo/{firstName}/{lastName}")
    public List<PersonInfoDTO> getPersonInfoList(@PathVariable String firstName, @PathVariable String lastName){
        List<PersonInfoDTO> personInfoDTOList = urlsService.getPersonInfoList(firstName, lastName);
        if (personInfoDTOList.isEmpty()){
            log.error("Find person info request FAILED, check firstname and lastname");
        } else {
            log.info("Find person info request SUCCESS");
        }
        return personInfoDTOList;
    }

    @GetMapping("/communityEmail/{city}")
    public EmailAlertDTO getCommunityEmailList(@PathVariable String city) {
        EmailAlertDTO emailAlertDTO = urlsService.getCommunityEmailList(city);
        if (emailAlertDTO.getEmailAlertList().isEmpty()){
            log.error("Find email by city request FAILED, check the city");
        } else {
            log.info("Find email by city request SUCCESS");
        }
        return emailAlertDTO;
    }
}
