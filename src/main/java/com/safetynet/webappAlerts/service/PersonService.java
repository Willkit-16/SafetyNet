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
import com.safetynet.webappAlerts.dto.PeopleByStationNumberDTO;
import com.safetynet.webappAlerts.dto.PeopleByStationNumberListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonDAO pdao;

	@Autowired
	FireStationDAO fsdao;

	@Autowired
	FireStationService fss;

	@Autowired
	MedicalRecordsDAO mdao;

	public List<Person> getPersons() {
		return pdao.getPersons();
	}

	public Person addPerson(Person pr) {
		return pdao.addPerson(pr);
	}

	public Person findPersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.findPersonByFirstNameAndLastName(firstName, lastName);
	}

	public boolean deletePersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.deletePersonByFirstAndLastName(firstName, lastName);

	}

	public Person updatePerson(String firstName, String lastName, String personsAddress, String city, String zip,
			String phone, String email) {
		return pdao.updatePerson(firstName, lastName, personsAddress, city, zip, phone, email);
	}

	public List<String> findPrByAddress(String personsAddress) {
		List<String> listPrAddress = new ArrayList<String>();
		for (Person p : pdao.getPersons()) {
			if (p.getAddress().equals(personsAddress)) {
				listPrAddress.add(p.getFirstName());
			}
		}
		return listPrAddress;
	}

	public List<String> listOfEmail(String city) {

		List<String> listEmail = new ArrayList<String>();
		for (Person p : pdao.getPersons()) {
			if (p.getCity().equals(city)) {
				listEmail.add(p.getEmail());
			}
		}
		return listEmail;
	}

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

	public PeopleByStationNumberListDTO listOfPeople(String station) {
		List<String> listAddressByNumber = new ArrayList<String>();
		PeopleByStationNumberListDTO pbsn = new PeopleByStationNumberListDTO();
		for (FireStation f : fsdao.getFireStations()) {
			if (f.getStation().equals(station)) {
				listAddressByNumber = fss.findFSByNumber(station);
			}
		}
		for (Person p : pdao.getPersons()) {
			if (listAddressByNumber.contains(p.getAddress())) {
				PeopleByStationNumberDTO pb = new PeopleByStationNumberDTO();
				pb.setFirstName(p.getFirstName());
				pb.setLastName(p.getLastName());
				pb.setAddress(p.getAddress());
				pb.setPhone(p.getPhone());
				pbsn.getPeopleList().add(pb);
				MedicalRecordsDAO mr = new MedicalRecordsDAO();

				for (MedicalRecords m : mr.getMedicalRecords()) {
					if (m.firstName.equals(p.firstName) && m.lastName.equals(p.lastName)) {
						LocalDate dEnd = LocalDate.now();
						if (ChronoUnit.YEARS.between(m.getBirthDate(), dEnd) <= 18) {
							pbsn.setMinor(pbsn.getMinor() + 1);
						} else {
							pbsn.setAdult(pbsn.getAdult() + 1);
							;
						}
					}
				}

			}

		}
		return pbsn;
	}
}
