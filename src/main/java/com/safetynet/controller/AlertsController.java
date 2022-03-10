package com.safetynet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.model.Persons;

@RestController
public class AlertsController {

	@GetMapping("/person")
	public String listOfPerson() {
		return "liste of person";
	}

	@GetMapping(value = "/person/{lastName}")
	public Persons showPersons(@PathVariable String lastName) {
		Persons persons = new Persons();
		return persons;
	}

	@GetMapping("/fireStation")
	public String listOfFireStation() {
		return "list of fire station";
	}

	@GetMapping("/medicalRecord")
	public String listOfMedicalRecords() {
		return "liste of medical record";
	}

}