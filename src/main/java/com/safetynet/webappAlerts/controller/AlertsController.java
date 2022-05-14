package com.safetynet.webappAlerts.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.dto.FireListDTO;
import com.safetynet.webappAlerts.dto.FloodListDTO;
import com.safetynet.webappAlerts.dto.PeopleByStationNumberListDTO;
import com.safetynet.webappAlerts.dto.PersonInfoListDTO;
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

	Logger log = Logger.getLogger("AlertsController");

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
	@GetMapping("/firestation/{station}/{address}")
	public FireStation findFSByStationNumberAndAddress(@PathVariable("station") String station,
			@PathVariable("address") String address) {
		return fs.findFSByStationAndAddress(station, address);
	}

	@GetMapping("/firestation/{station}")
	public List<String> findFSByNumber(@PathVariable("station") String station) {
		return fs.findFSByNumber(station);
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
	@DeleteMapping("/firestation/{station}/{address}")
	public boolean deleteFSByStationNumberAndAddresse(@PathVariable("station") String station,
			@PathVariable("address") String address) {
		return fs.deleteFSByStationAndAddress(station, address);
	}

	/**
	 * Update fire station.
	 *
	 * @param stationNumber the station number
	 * @param address       the address
	 * @return the fire station
	 */
	@PutMapping("/firestation/{station}/{address}")
	public FireStation updateFireStation(@PathVariable("station") String station,
			@PathVariable("address") String address) {
		return fs.updateFireStation(station, address);
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
			@PathVariable("lastName") String lastName, @PathVariable("birthDate") LocalDate birthDate,
			@PathVariable("medications") String medications, @PathVariable("allergies") String allergies) {
		return mr.updateMR(firstName, lastName, birthDate, medications, allergies);

	}

	/**
	 * List of email.
	 *
	 * @param pr the pr
	 * @return the list
	 */
	@GetMapping("/communityEmail")
	public ResponseEntity<List<String>> listOfEmail(@RequestParam(value = "city") String city) {
		log.info("GET /communityEmail/?city=" + city);
		try {
			return ResponseEntity.ok(ps.listOfEmail(city));
		} catch (NoSuchElementException e) {
			log.info("GET /communityEmail/?city=" + city + " - ERROR : " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/phoneAlert")
	public ResponseEntity<List<String>> listOfPhone(@RequestParam(value = "firestation") String station) {
		log.info("GET /phoneAlert/?firestation=" + station);
		try {
			return ResponseEntity.ok(ps.listOfPhone(station));
		} catch (NoSuchElementException e) {
			log.info("GET /phoneAlert/?firestation=" + station + " - ERROR : " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/firestation")
	public ResponseEntity<PeopleByStationNumberListDTO> listOfPersonByStation(
			@RequestParam(value = "stationNumber") String station) {
		log.info("GET /firestation/?stationNumber=" + station);
		try {
			return ResponseEntity.ok(ps.listOfPeople(station));
		} catch (NoSuchElementException e) {
			log.info("GET /firestation/?stationNumber=" + station + " - ERROR : " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/childAlert")
	public ResponseEntity<ChildAlertListDTO> listOfChildren(@RequestParam(value = "address") String personsAddress) {
		log.info("GET /childAlert/?address=" + personsAddress);
		try {
			return ResponseEntity.ok(mr.listOfChildren(personsAddress));
		} catch (NoSuchElementException e) {
			log.info("GET /childAlert/?address=" + personsAddress + "- ERROR : " + e.getMessage());
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/fire")
	public ResponseEntity<FireListDTO> listByAddress(@RequestParam(value = "address") String personsAddress) {
		log.info("GET /fire/?address=" + personsAddress);
		try {
			return ResponseEntity.ok(mr.listByAddress(personsAddress));
		} catch (NoSuchElementException e) {
			log.info("GET /fire/?address=" + personsAddress + "- ERROR : " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/flood/stations")
	public ResponseEntity<FloodListDTO> familyByStation(@RequestParam(value = "stations") String station) {
		log.info("GET /flood/stations/?stations=" + station);
		try {
			return ResponseEntity.ok(mr.familyByStation(station));
		} catch (NoSuchElementException e) {
			log.info("GET /fire/?address=" + station + "- ERROR : " + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/personInfo")
	public ResponseEntity<PersonInfoListDTO> personInfo(
			@RequestParam(value = "firstName" + "lastName") String firstName, String lastName) {
		log.info("GET /personInfo?firstName=" + firstName + "lastName=" + lastName);

		try {
			return ResponseEntity.ok(mr.personInfo(firstName, lastName));
		} catch (NoSuchElementException e) {
			log.info("GET /personInfo?firstName=" + firstName + lastName + "- ERROR :" + e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
}