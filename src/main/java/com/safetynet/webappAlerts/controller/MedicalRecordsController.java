package com.safetynet.webappAlerts.controller;

import java.time.LocalDate;
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

import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.service.FireStationService;
import com.safetynet.webappAlerts.service.MedicalRecordsService;
import com.safetynet.webappAlerts.service.PersonService;

@RestController
public class MedicalRecordsController {

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

	Logger log = Logger.getLogger("Medical Records Controller");

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

}
