package com.safetynetalerts.webapp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalerts.webapp.model.Person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.io.IOException;


@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);

		ObjectMapper mapper = new ObjectMapper();

		try {
			Person person = mapper.readValue(new File("src/main/resources/data.json"), Person.class);

			System.out.println(person);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}












