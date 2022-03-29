package com.safetynet.webappAlerts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.safetynet.webappAlerts.controller.AlertsReader;

// TODO: Auto-generated Javadoc
/**
 * The Class WebappAlertsApplication.
 */
@Configuration

@EnableAutoConfiguration

@ComponentScan
public class WebappAlertsApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException           Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(WebappAlertsApplication.class, args);
		AlertsReader ar = new AlertsReader();
		ar.readDataFromJson();
	}

}
