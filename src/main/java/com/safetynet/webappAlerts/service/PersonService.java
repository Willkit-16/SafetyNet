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
import com.safetynet.webappAlerts.dto.ChildAlertDTO;
import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.dto.FireDTO;
import com.safetynet.webappAlerts.dto.FireListDTO;
import com.safetynet.webappAlerts.dto.PersonInfoDTO;
import com.safetynet.webappAlerts.dto.PersonInfoListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonService.
 */
@Service
public class PersonService {

	/** The pdao. */
	@Autowired
	PersonDAO pdao;

	/** The fsdao. */
	@Autowired
	FireStationDAO fsdao;

	/** The fss. */
	@Autowired
	FireStationService fss;

	/** The mdao. */
	@Autowired
	MedicalRecordsDAO mdao;

	/**
	 * Gets the persons.
	 *
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return pdao.getPersons();
	}

	/**
	 * Adds the person.
	 *
	 * @param pr the pr
	 * @return the person
	 */
	public Person addPerson(Person pr) {
		return pdao.addPerson(pr);
	}

	/**
	 * Find person by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the person
	 */
	public Person findPersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.findPersonByFirstNameAndLastName(firstName, lastName);
	}

	/**
	 * Delete person by first and last name.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return true, if successful
	 */
	public boolean deletePersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.deletePersonByFirstAndLastName(firstName, lastName);

	}

	/**
	 * Update person.
	 *
	 * @param firstName      the first name
	 * @param lastName       the last name
	 * @param personsAddress the persons address
	 * @param city           the city
	 * @param zip            the zip
	 * @param phone          the phone
	 * @param email          the email
	 * @return the person
	 */
	public Person updatePerson(String firstName, String lastName, String personsAddress, String city, String zip,
			String phone, String email) {
		return pdao.updatePerson(firstName, lastName, personsAddress, city, zip, phone, email);
	}

	/**
	 * List of email.
	 *
	 * @param city the city
	 * @return the list
	 */
	public List<String> listOfEmail(String city) {

		List<String> listEmail = new ArrayList<String>();
		for (Person p : pdao.getPersons()) {
			if (p.getCity().equals(city)) {
				listEmail.add(p.getEmail());
			}
		}
		return listEmail;
	}

	/**
	 * List of phone.
	 *
	 * @param station the station
	 * @return the list
	 */
	public List<String> listOfPhone(String station) {
		List<String> listPhone = new ArrayList<String>();
		List<String> listAddressByNumber = new ArrayList<String>();

		for (FireStation f : fsdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddressByNumber = fss.findFSByNumber(station);
			}
		}
		for (Person p : pdao.getPersons()) {
			if (listAddressByNumber.contains(p.getAddress())) {
				listPhone.add(p.getPhone());
			}
		}

		return listPhone;

	}

	/**
	 * List of children.
	 *
	 * @param personsAddress the persons address
	 * @return the child alert list DTO
	 */
	public ChildAlertListDTO listOfChildren(String personsAddress) {
		List<String> listOfChildrenByAddress = new ArrayList<String>();
		long age = 0;
		ChildAlertListDTO cal = new ChildAlertListDTO();

		for (Person p : pdao.getPersons()) {
			if (p.getAddress().equals(personsAddress)) {
				listOfChildrenByAddress.add(p.getFirstName());
				listOfChildrenByAddress.add(p.getLastName());
			}

			for (MedicalRecords m : mdao.getMedicalRecords()) {
				if (listOfChildrenByAddress.contains(m.getLastName())) {
					LocalDate dEnd = LocalDate.now();
					age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);
					if (age <= 18) {
						if (m.getFirstName().equals(p.getFirstName()) && m.getLastName().equals(p.getLastName())) {
							ChildAlertDTO ca = new ChildAlertDTO();
							ca.setFirstName(m.getFirstName());
							ca.setLastName(m.getLastName());
							ca.setAge(age);
							cal.getListOfChildren().add(ca);
							cal.setFoyer(listOfChildrenByAddress);
						}
					}
				}
			}
		}
		return cal;
	}

	/**
	 * List by address.
	 *
	 * @param personsAddress the persons address
	 * @return the fire list DTO
	 */
	public FireListDTO listByAddress(String personsAddress) {
		List<String> listOfPersonByAddress = new ArrayList<String>();
		long age = 0;
		FireListDTO fl = new FireListDTO();

		for (Person p : pdao.getPersons()) {
			if (p.getAddress().equals(personsAddress)) {
				listOfPersonByAddress.add(p.getFirstName());
				listOfPersonByAddress.add(p.getLastName());
			}

			for (MedicalRecords m : mdao.getMedicalRecords()) {
				if (listOfPersonByAddress.contains(m.getLastName())) {
					LocalDate dEnd = LocalDate.now();
					age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);

					if (m.getFirstName().equals(p.getFirstName()) && m.getLastName().equals(p.getLastName())) {
						FireDTO fd = new FireDTO();
						fd.setFirstName(m.getFirstName());
						fd.setLastName(m.getLastName());
						fd.setAge(age);
						fd.setMedications(m.getMedications());
						fd.setAllergies(m.getAllergies());
						fd.setPhone(p.getPhone());
						fl.getListOfPersonByAddress().add(fd);
					}
				}
				for (FireStation f : fsdao.getFireStations()) {
					if (personsAddress.equals(f.getAddress())) {
						fl.setStationNumber(f.getStation());
					}
				}
			}
		}

		return fl;
	}

	/**
	 * Person info.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @return the person info list DTO
	 */
	public PersonInfoListDTO personInfo(String firstName, String lastName) {
		List<String> findOne = new ArrayList<String>();
		PersonInfoListDTO pldto = new PersonInfoListDTO();
		long age = 0;

		for (Person p : pdao.getPersons()) {
			if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
				findOne.add(firstName);
				findOne.add(lastName);

				for (MedicalRecords m : mdao.getMedicalRecords()) {
					if (findOne.contains(m.getFirstName())) {
						PersonInfoDTO pi = new PersonInfoDTO();
						LocalDate dEnd = LocalDate.now();
						age = ChronoUnit.YEARS.between(m.getBirthDate(), dEnd);

						pi.setFirstName(m.getFirstName());
						pi.setLastName(m.getLastName());
						pi.setAddress(p.getAddress());
						pi.setAge(age);
						pi.setMail(p.getEmail());
						pi.setMedications(m.getMedications());
						pi.setAllergies(m.getAllergies());
						pldto.getPersonInfoList().add(pi);
					}
				}
			}
		}
		return pldto;

	}
}
