package com.safetynet.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Data;
import com.safetynet.model.FireStations;
import com.safetynet.model.Persons;

@RestController
public class AlertsController {

	@Autowired
	AlertsReader ar = new AlertsReader();
	Data data = new Data();

	@GetMapping("/Person")
	public Persons listOfPerson() throws FileNotFoundException, IOException {

		ar.readDataFromJson();
		Persons persons = new Persons();

		return persons;
	}

	@GetMapping(value = "/Person/{lastName}")
	public Persons showPersons(@PathVariable String lastName) {
		Persons persons = new Persons();
		return persons;
	}

	@GetMapping("/FireStation")
	public String listOfFireStation() {
		return "list of fire station";
	}

	@GetMapping(value = "/FireStation/{station}")
	public FireStations personByAddress(@PathVariable String stationNumber) {
		Persons persons = new Persons();
		FireStations fStations = new FireStations();

		return null;
	}

	@GetMapping("/MedicalRecord")
	public String listOfMedicalRecords() {
		return "liste of medical record";
	}

}