package com.safetynetalerts.webapp.controller;


import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.service.FireStationService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class FireStationController {

    @Autowired
    private FireStationService fireStationService;


    @GetMapping("/firestation")
    public List<FireStation> getFireStations() {
        List<FireStation> fireStationList = fireStationService.getFireStations();
        if (fireStationList.isEmpty()) {
            log.error("Find all firestations request FAILED");
        } else {
            log.info("Find all firestations request SUCCESS");
        }
        return fireStationList ;
    }

    @PostMapping("/firestation")
    public boolean addFireStation(@RequestParam String address, @RequestParam String station) {
        FireStation fireStation = new FireStation(address, station);
        log.info("Post firestation request SUCCESS");
        return fireStationService.addFireStation(fireStation);
    }

    @DeleteMapping("/firestation")
    public boolean deleteFireStation(@RequestParam String address) {
        boolean deleteFireStation = fireStationService.deleteFireStation(address);
        if (deleteFireStation) {
            log.info("Delete firestation request SUCCESS");
        } else {
            log.error("Delete firestation request FAILED, the address doesn't exist");
        }
        return deleteFireStation;
    }

    @PutMapping("/firestation")
    public boolean updateFireStation(@RequestParam String address, @RequestParam String station) {
        boolean updateFireStation = fireStationService.updateFireStation(address,station);
        if (updateFireStation) {
            log.info("Update firestation request SUCCESS");
        } else {
            log.error("Update firestation request FAILED, the address doesn't exist");
        }
        return updateFireStation;
    }
}

