package com.safetynetalerts.webapp.controller;

import com.safetynetalerts.webapp.dto.*;
import com.safetynetalerts.webapp.service.UrlsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UrlsController {

    @Autowired
    private UrlsService urlsService;


    @GetMapping(value = "/firestation")
    public PersonsListByStationNumberDTO getPersonsListsFromStationNumber(@RequestParam(value = "station") String station) {
        PersonsListByStationNumberDTO personsListByStationNumberDTO = urlsService.getPersonsListsFromStationNumber(station);
        if (personsListByStationNumberDTO.getPersonsByStationNumbers().isEmpty()) {
            log.error("Find all person by station number request FAILED");
        } else {
            log.info("Find all persons by station number request SUCCESS");
        }
        return personsListByStationNumberDTO;
    }

    @GetMapping(value = "/childAlert")
    public List<ChildAlertDTO> getChildListByAddress(@RequestParam(value = "address") String address) {
        List<ChildAlertDTO> childAlertDTOList = urlsService.getChildListByAddress(address);
        if (childAlertDTOList.isEmpty()) {
            log.error("Find all child by home request FAILED, address not found or no child found at this address");
        } else {
            log.info("Find all child by home request SUCCESS");
        }
        return childAlertDTOList;
    }


    @GetMapping(value = "/phoneAlert")
    public PhoneAlertDTO getPhoneNumberByFirestationNumber(@RequestParam(value = "station") String station) {
        PhoneAlertDTO phoneAlertDTO =urlsService.getPhoneNumberListByFirestationNumber(station);
        if (phoneAlertDTO.getPhoneAlertList().isEmpty()){
            log.error("Find all phone number by firestation number request FAILED, station number not found");
        } else {
            log.info("Find all phone number by firestation number request SUCCESS");
        }
        return phoneAlertDTO;
    }

    @GetMapping(value = "/fire")
    public FireAddressListDTO getPersonsListByAddress(@RequestParam(value = "address") String address) {
        FireAddressListDTO fireAddressListDTO = urlsService.getPersonsListByAddress(address);
        if (fireAddressListDTO.getFireAddressList().isEmpty()){
            log.error("Find person by address' firestation request FAILED, address not found");
        } else {
            log.info("Find person by address' firestation request SUCCESS");
        }
        return fireAddressListDTO;
    }

    @GetMapping(value = "/flood/stations")
    public List<HomeByStationNumberDTO> getHomeByStationNumber(@RequestParam(value = "station")String station){
        List<HomeByStationNumberDTO> homeByStationNumberDTOList = urlsService.getHomeByStationNumber(station);
        if (homeByStationNumberDTOList.isEmpty()){
            log.error("Find homes by firestation number request FAILED, station number doesn't exist");
        } else {
            log.info("Find homes by firestation number request SUCCESS");
        }
        return homeByStationNumberDTOList;
    }

    @GetMapping(value = "/personInfo")
    public List<PersonInfoDTO> getPersonInfoList(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName){
        List<PersonInfoDTO> personInfoDTOList = urlsService.getPersonInfoList(firstName, lastName);
        if (personInfoDTOList.isEmpty()){
            log.error("Find person info request FAILED, check firstname and lastname");
        } else {
            log.info("Find person info request SUCCESS");
        }
        return personInfoDTOList;
    }

    @GetMapping(value = "/communityEmail")
    public EmailAlertDTO getCommunityEmailList(@RequestParam(value = "city") String city) {
        EmailAlertDTO emailAlertDTO = urlsService.getCommunityEmailList(city);
        if (emailAlertDTO.getEmailAlertList().isEmpty()){
            log.error("Find email by city request FAILED, check the city");
        } else {
            log.info("Find email by city request SUCCESS");
        }
        return emailAlertDTO;
    }
}
