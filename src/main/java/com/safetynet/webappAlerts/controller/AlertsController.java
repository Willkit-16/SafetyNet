package com.safetynet.webappAlerts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * Adds the fire station.
	 *
	 * @param fr the fr
	 * @return the fire station
	 */
	@PostMapping("/firestations")
	public FireStation addFireStation(@RequestBody FireStation fr) {
		return fs.addFireStation(fr);

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

	/**
	 * Update fire station.
	 *
	 * @param stationNumber the station number
	 * @param address       the address
	 * @return the fire station
	 */
	@PutMapping("/firestation/{stationNumber}/{address}")
	public FireStation updateFireStation(@PathVariable("stationNumber") String stationNumber,
			@PathVariable("address") String address) {
		return fs.updateFireStation(stationNumber, address);
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
	 * Adds the medical records.
	 *
	 * @param mrs the mrs
	 * @return the medical records
	 */
	@PostMapping("/medicalrecords")
	public MedicalRecords addMedicalRecords(@RequestBody MedicalRecords mrs) {
		return mr.addMedicalRecords(mrs);
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
	 * Update MR.
	 *
	 * @param firstName   the first name
	 * @param lastName    the last name
	 * @param birthDate   the birth date
	 * @param medications the medications
	 * @param allergies   the allergies
	 * @return the medical records
	 */
	@PutMapping("/medicalrecords/{firstName}/{lastName}/{birthDate}/{medications}/{allergies}")
	public MedicalRecords updateMR(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName, @PathVariable("birthDate") String birthDate,
			@PathVariable("medications") String medications, @PathVariable("allergies") String allergies) {
		return mr.updateMR(firstName, lastName, birthDate, medications, allergies);

	}

	/**
	 * List of fs.
	 *
	 * @return the string
	 */
	@GetMapping("/firestation?stationNumber={station}")
	public String listOfFs() {
		return null;
	}

	/**
	 * List of email.
	 *
	 * @param pr the pr
	 * @return the list
	 */
	@GetMapping("/communityEmail?city={city}")
	public Person listOfEmail(@PathVariable("city") String city, String email) {
		return ps.listOfEmail(city, email);
	}

}