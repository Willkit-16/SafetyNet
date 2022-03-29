package com.safetynet.webappAlerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webappAlerts.model.Person;
import com.safetynet.webappAlerts.service.PersonService;

@RestController
public class AlertsController {

	@Autowired
	AlertsReader ar;
	@Autowired
	PersonService ps;

	@GetMapping("/persons")
	public List<Person> listOfPerson() {
		return ps.getPersons();
	}

	@GetMapping("/person/{firstName}/{lastName}")
	public Person findPersonByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return ps.findPersonByFirstAndLastName(firstName, lastName);
	}

	@DeleteMapping("/person/{firstName}/{lastName}")
	public Person deletePersonByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return ps.deletePersonByFirstAndLastName(firstName, lastName);
	}

	@PostMapping("/person")

	@PutMapping("/person")

	@GetMapping("firestation?stationNumber=<station_number>")
	public String listOfFs() {
		return null;

	}

}