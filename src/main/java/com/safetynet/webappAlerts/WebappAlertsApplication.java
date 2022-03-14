package com.safetynet.webappAlerts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.safetynet.controller.AlertsReader;

@SpringBootApplication
public class WebappAlertsApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(WebappAlertsApplication.class, args);
		AlertsReader ar = new AlertsReader();

		ar.readDataFromJson();
		System.out.println(ar);
	}

}
