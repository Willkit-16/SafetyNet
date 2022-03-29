package com.safetynet.webappAlerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;
import com.safetynet.webappAlerts.service.FireStationService;
import com.safetynet.webappAlerts.service.MedicalRecordsService;
import com.safetynet.webappAlerts.service.PersonService;

// TODO: Auto-generated Javadoc
/**
 * The Class AlertsController.
 */
@RestController
public class AlertsController {

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

	@PostMapping("/person")
	public ResponseEntity<String> addPerson(String firstName, String lastName, String personAddress, String city,
			String zip, String phone, String email) {
		if (ps.createAndAddPerson(firstName, lastName, personAddress, city, zip, phone, email)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
		}
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

	// FireStation

	/**
	 * List of fire station.
	 *
	 * @return the list
	 */
	@GetMapping("/firestations")
	public List<FireStation> listOfFireStation() {
		return fs.getFireStations();
	}

	/**
	 * Find FS by station number and address.
	 *
	 * @param stationNumber the station number
	 * @param address       the address
	 * @return the fire station
	 */
	@GetMapping("/firestation/{stationNumber}/{address}")
	public FireStation findFSByStationNumberAndAddress(@PathVariable("stationNumber") String stationNumber,
			@PathVariable("address") String address) {
		return fs.findFSByStationAndAddress(stationNumber, address);
	}

	/**
	 * Delete FS by station number and addresse.
	 *
	 * @param stationNumber the station number
	 * @param address       the address
	 * @return true, if successful
	 */
	@DeleteMapping("/firestation/{stationNumber}/{address}")
	public boolean deleteFSByStationNumberAndAddresse(@PathVariable("stationNumber") String stationNumber,
			@PathVariable("address") String address) {
		return fs.deleteFSByStationAndAddress(stationNumber, address);
	}

	// Medical Records

	/**
	 * List of MR.
	 *
	 * @return the list
	 */
	@GetMapping("/medicalrecords")
	public List<MedicalRecords> listOfMR() {
		return mr.getMedicalRecords();
	}

	/**
	 * Find MR by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the medical records
	 */
	@GetMapping("/medicalrecords/{firstName}/{lastName}")
	public MedicalRecords findMRByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return mr.findMRByFirstAndLastName(firstName, lastName);
	}

	/**
	 * Delete MR by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return true, if successful
	 */
	@DeleteMapping("/medicalrecords/{firstName}/{lastName}")
	public boolean deleteMRByFirstAndLastName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return mr.deleteMRByFirstAndLastName(firstName, lastName);
	}

	/**
	 * List of fs.
	 *
	 * @return the string
	 */
	@GetMapping("firestation?stationNumber=<station_number>")
	public String listOfFs() {
		return null;

	}

}