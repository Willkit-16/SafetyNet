package com.safetynet.webappAlerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertsController {

	@Autowired
	AlertsReader ar;

	@GetMapping("/person")
	public String listOfPerson() {
		return "List";
	}

	@PostMapping("/person")

	@PutMapping("/person")

	@DeleteMapping("/person")

	@GetMapping("firestation?stationNumber=<station_number>")
	public String listOfFs() {
		return null;

	}

}