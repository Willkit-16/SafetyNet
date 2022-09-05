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

import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.service.FireStationService;
import com.safetynet.webappAlerts.service.MedicalRecordsService;
import com.safetynet.webappAlerts.service.PersonService;

@RestController
public class FireStationController {

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

	Logger log = Logger.getLogger("Fire Station Controller");

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
	public FireStation updateFireStation(@PathVariable("address") String address,
			@PathVariable("station") String station) {
		return fs.updateFireStation(station, address);
	}
}
