package com.safetynetalerts.webapp.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LaunchMapper {
    public void launchMapper() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            Data data = mapper.readValue(new File("src/main/resources/data.json"), Data.class);
            System.out.println(data.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
