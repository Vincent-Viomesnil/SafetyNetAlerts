package com.safetynetalerts.webapp;
import com.safetynetalerts.webapp.data.Data;
import com.safetynetalerts.webapp.data.LaunchMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
		LaunchMapper launchMapper = new LaunchMapper();
		launchMapper.launchMapper();
	}
}












