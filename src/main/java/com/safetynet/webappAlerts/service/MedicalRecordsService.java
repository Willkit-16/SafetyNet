package com.safetynet.webappAlerts.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.dto.FloodDTO;
import com.safetynet.webappAlerts.dto.FloodListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class MedicalRecordsService.
 */
@Service
public class MedicalRecordsService {

	/** The mrdao. */
	@Autowired
	MedicalRecordsDAO mrdao;

	/** The pdao. */
	@Autowired
	PersonDAO pdao;

	/** The fdao. */
	@Autowired
	FireStationDAO fdao;

	/** The fss. */
	@Autowired
	FireStationService fss;

	/** The ps. */
	@Autowired
	PersonService ps;

	/**
	 * Gets the medical records.
	 *
	 * @return the medical records
	 */
	public List<MedicalRecords> getMedicalRecords() {
		return mrdao.getMedicalRecords();
	}

	/**
	 * Find MR by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the medical records
	 */
	public MedicalRecords findMRByFirstAndLastName(String firstName, String lastName) {
		return mrdao.findMRByFirstNameAndLastName(firstName, lastName);
	}

	/**
	 * Delete MR by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return true, if successful
	 */
	public boolean deleteMRByFirstAndLastName(String firstName, String lastName) {
		return mrdao.deleteMRByFirstAndLastName(firstName, lastName);

	}

	/**
	 * Adds the medical records.
	 *
	 * @param mr the mr
	 * @return the medical records
	 */
	public MedicalRecords addMedicalRecords(MedicalRecords mr) {
		return mrdao.addMedicalRecords(mr);
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
	public MedicalRecords updateMR(String firstName, String lastName, String birthDate, String medications,
			String allergies) {

		LocalDate localDate = LocalDate.parse(birthDate);

		return mrdao.updateMR(firstName, lastName, localDate, medications, allergies);
	}

	/**
	 * Family by station.
	 *
	 * @param station the station
	 * @return the flood list DTO
	 */
	public FloodListDTO familyByStation(String station) {
		List<String> listAddressByNumber = new ArrayList<String>();
		FloodListDTO fldto = new FloodListDTO();
		long age = 0;
		for (FireStation f : fdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddressByNumber = fss.findFSByNumber(station);
			}

		}
		for (Person p : pdao.getPersons()) {
			if (listAddressByNumber.contains(p.getAddress())) {
				FloodDTO fd = new FloodDTO();
				LocalDate dEnd = LocalDate.now();
				fd.setAddress(p.getAddress());

				for (MedicalRecords m : mrdao.getMedicalRecords()) {
					if (m.firstName.equals(p.firstName) && m.lastName.equals(p.lastName)) {
						age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);
						fd.setFirstName(p.getFirstName());
						fd.setLastName(p.getLastName());
						fd.setPhone(p.getPhone());
						fd.setAge(age);
						fd.setMedications(m.getMedications());
						fd.setAllergies(m.getAllergies());
						fldto.getFamilyByStation().add(fd);
					}
				}
			}
		}
		return fldto;
	}
}
