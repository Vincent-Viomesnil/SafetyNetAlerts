package com.safetynetalerts.webapp;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.model.Person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.*;
import java.util.List;


@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);

		// externaliser, read data. dans un autre fchier
		try {
			ObjectMapper mapper = new ObjectMapper();
			Data data = mapper.readValue(new File("src/main/resources/data.json"), Data.class);

			System.out.println(data.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}












