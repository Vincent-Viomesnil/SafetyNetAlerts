package com.safetynetalerts.webapp.controller;


import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.service.FireStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class FireStationController {

    @Autowired
    private FireStationService fireStationService;


    @GetMapping("/firestation")
    public Iterable<FireStation> getFireStations() {return fireStationService.getFireStations();
    }

    @PostMapping("/firestation")
    public boolean addFireStation(@RequestParam String address, @RequestParam String station) {
        FireStation fireStation = new FireStation(address, station);
        if (fireStation != null) {
            log.info("Post Firestation request SUCCESS");
        } else {
            log.error("Post Firestation request FAILED");
        }
        return fireStationService.addFireStation(fireStation);
    }

    @DeleteMapping("/firestation")
    public boolean deleteFireStation(@RequestParam String address) {
        return fireStationService.deleteFireStation(address);
    }

    @PutMapping("/firestation")
    public boolean updateFireStation(@RequestParam String address, @RequestParam String station) {
        return fireStationService.updateFireStation(address,station);
    }
}

