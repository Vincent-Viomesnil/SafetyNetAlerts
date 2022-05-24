package com.safetynetalerts.webapp.controller;


import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FireStationController {

    @Autowired
    private FireStationService fireStationService;

    @GetMapping("/firestation")
    public Iterable<FireStation> getFireStations() {
        return fireStationService.getFireStations();
    }

    @PostMapping("/firestation")
    public boolean addFireStation(@RequestParam String address, @RequestParam String station) {
        FireStation fireStation = new FireStation(address, station);
        return fireStationService.addFireStation(fireStation);
    }

    @DeleteMapping("/firestation")
    public boolean deleteFireStation(@RequestParam String address) {
        return fireStationService.deleteFireStation(address);
    }
}

