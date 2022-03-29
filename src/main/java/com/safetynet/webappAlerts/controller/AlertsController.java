package com.safetynet.webappAlerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;
import com.safetynet.webappAlerts.service.FireStationService;
import com.safetynet.webappAlerts.service.MedicalRecordsService;
import com.safetynet.webappAlerts.service.PersonService;

@RestController
public class AlertsController {

	@Autowired
	AlertsReader ar;
	@Autowired
	PersonService ps;
	@Autowired
	FireStationService fs;
	@Autowired
	MedicalRecordsService mr;

	// Person

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
	public boolean deletePersonByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return ps.deletePersonByFirstAndLastName(firstName, lastName);
	}

	// FireStation
	@GetMapping("/firestations")
	public List<FireStation> listOfFireStation() {
		return fs.getFireStations();
	}

	@GetMapping("/firestation/{stationNumber}/{address}")
	public FireStation findFSByStationNumberAndAddress(@PathVariable("stationNumber") String stationNumber,
			@PathVariable("address") String address) {
		return fs.findFSByStationAndAddress(stationNumber, address);
	}

	@DeleteMapping("/firestation/{stationNumber}/{address}")
	public boolean deleteFSByStationNumberAndAddresse(@PathVariable("stationNumber") String stationNumber,
			@PathVariable("address") String address) {
		return fs.deleteFSByStationAndAddress(stationNumber, address);
	}

	// Medical Records
	@GetMapping("/medicalrecords")
	public List<MedicalRecords> listOfMR() {
		return mr.getMedicalRecords();
	}

	@GetMapping("/medicalrecords/{firstName}/{lastName}")
	public MedicalRecords findMRByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return mr.findMRByFirstAndLastName(firstName, lastName);
	}

	@DeleteMapping("/medicalrecords/{firstName}/{lastName}")
	public boolean deleteMRByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return mr.deleteMRByFirstAndLastName(firstName, lastName);
	}

	@GetMapping("firestation?stationNumber=<station_number>")
	public String listOfFs() {
		return null;

	}

}