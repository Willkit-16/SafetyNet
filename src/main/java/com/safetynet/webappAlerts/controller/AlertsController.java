package com.safetynet.webappAlerts.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.dto.FireListDTO;
import com.safetynet.webappAlerts.dto.FloodListDTO;
import com.safetynet.webappAlerts.dto.PeopleByStationNumberListDTO;
import com.safetynet.webappAlerts.dto.PersonInfoListDTO;
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

	/** The log. */
	Logger log = Logger.getLogger("AlertsController");

	/**
	 * List of email.
	 *
	 * @param city the city
	 * @return the response entity
	 */
	@GetMapping("/communityEmail")
	public ResponseEntity<List<String>> listOfEmail(@RequestParam(value = "city") String city) {
		log.info("GET /communityEmail/?city=" + city);

		return ResponseEntity.ok(ps.listOfEmail(city));

	}

	/**
	 * List of phone.
	 *
	 * @param station the station
	 * @return the response entity
	 */
	@GetMapping("/phoneAlert")
	public ResponseEntity<List<String>> listOfPhone(@RequestParam(value = "firestation") String station) {
		log.info("GET /phoneAlert/?firestation=" + station);

		return ResponseEntity.ok(ps.listOfPhone(station));

	}

	/**
	 * List of person by station.
	 *
	 * @param station the station
	 * @return the response entity
	 */
	@GetMapping("/firestation")
	public ResponseEntity<PeopleByStationNumberListDTO> listOfPersonByStation(
			@RequestParam(value = "stationNumber") String station) {
		log.info("GET /firestation/?stationNumber=" + station);

		return ResponseEntity.ok(fs.listOfPeople(station));

	}

	/**
	 * List of children.
	 *
	 * @param personsAddress the persons address
	 * @return the response entity
	 */
	@GetMapping("/childAlert")
	public ResponseEntity<ChildAlertListDTO> listOfChildren(@RequestParam(value = "address") String personsAddress) {
		log.info("GET /childAlert/?address=" + personsAddress);

		return ResponseEntity.ok(ps.listOfChildren(personsAddress));

	}

	/**
	 * List by address.
	 *
	 * @param personsAddress the persons address
	 * @return the response entity
	 */
	@GetMapping("/fire")
	public ResponseEntity<FireListDTO> listByAddress(@RequestParam(value = "address") String personsAddress) {
		log.info("GET /fire/?address=" + personsAddress);

		return ResponseEntity.ok(ps.listByAddress(personsAddress));

	}

	/**
	 * Family by station.
	 *
	 * @param station the station
	 * @return the response entity
	 */
	@GetMapping("/flood/stations")
	public ResponseEntity<FloodListDTO> familyByStation(@RequestParam(value = "stations") String station) {
		log.info("GET /flood/stations/?stations=" + station);
		return ResponseEntity.ok(mr.familyByStation(station));

	}

	/**
	 * Person info.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the response entity
	 */
	@GetMapping("/personInfo")
	public ResponseEntity<PersonInfoListDTO> personInfo(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		log.info("GET /personInfo?firstName=" + firstName + "lastName=" + lastName);

		return ResponseEntity.ok(ps.personInfo(firstName, lastName));

	}
}