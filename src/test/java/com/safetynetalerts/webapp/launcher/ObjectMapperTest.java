package com.safetynetalerts.webapp.launcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.data.LaunchMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ObjectMapperTest {

    @Test
    void launchMapper() throws IOException {
        LaunchMapper launchMapper = new LaunchMapper();
        ObjectMapper objectMapper = new ObjectMapper();

        Data data = objectMapper.readValue(new File("src/main/resources/data.json"), Data.class);

        launchMapper.launchMapper();

        assertNotNull(data.toString());
        }
    }

