package com.safetynetalerts.webapp.controller;


import com.safetynetalerts.webapp.model.FireStation;
import com.safetynetalerts.webapp.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FireStationController {

    @Autowired
    private FireStationService fireStationService;

    @GetMapping("/firestations")
    public Iterable<FireStation> getFireStations() { return fireStationService.getFireStations();
    }
}

