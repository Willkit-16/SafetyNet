package com.safetynet.webappAlerts.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webappAlerts.model.Person;
import com.safetynet.webappAlerts.service.FireStationService;
import com.safetynet.webappAlerts.service.MedicalRecordsService;
import com.safetynet.webappAlerts.service.PersonService;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonController.
 */
@RestController
public class PersonController {

	/** The ar. */
	@Autowired
	AlertsReader ar;

	/** The ps. */
	@Autowired
	PersonService ps;

	/** The fs. */
	@Autowired
	FireStationService fs;

	/** The mr. */
	@Autowired
	MedicalRecordsService mr;

	/** The log. */
	Logger log = Logger.getLogger("Person Controller");

	// Person

	/**
	 * List of person.
	 *
	 * @return the list
	 */
	@GetMapping("/persons")
	public List<Person> listOfPerson() {
		return ps.getPersons();
	}

	/**
	 * Adds the person.
	 *
	 * @param pr the pr
	 * @return the person
	 */
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person pr) {
		return ps.addPerson(pr);
	}

	/**
	 * Find person by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the person
	 */
	@GetMapping("/person/{firstName}/{lastName}")
	public Person findPersonByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return ps.findPersonByFirstAndLastName(firstName, lastName);
	}

	/**
	 * Update person by name.
	 *
	 * @param firstName      the first name
	 * @param lastName       the last name
	 * @param city           the city
	 * @param zip            the zip
	 * @param phone          the phone
	 * @param email          the email
	 * @param personsAddress the persons address
	 * @return the person
	 */
	@PutMapping("/person/{firstName}/{lastName}/{city}/{zip}/{phone}/{email}/{personsAddress}")
	public Person updatePersonByName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName, @PathVariable("city") String city,
			@PathVariable("zip") String zip, @PathVariable("phone") String phone, @PathVariable("email") String email,
			@PathVariable("personsAddress") String personsAddress) {
		return ps.updatePerson(firstName, lastName, city, zip, phone, email, personsAddress);

	}

	/**
	 * Delete person by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return true, if successful
	 */
	@DeleteMapping("/person/{firstName}/{lastName}")
	public boolean deletePersonByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return ps.deletePersonByFirstAndLastName(firstName, lastName);
	}
}
