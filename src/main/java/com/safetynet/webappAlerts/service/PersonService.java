package com.safetynet.webappAlerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonDAO pdao;

	@Autowired
	FireStationDAO fsdao;

	@Autowired
	FireStationService fss;

	public List<Person> getPersons() {
		return pdao.getPersons();
	}

	public Person addPerson(Person pr) {
		return pdao.addPerson(pr);
	}

	public Person findPersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.findPersonByFirstNameAndLastName(firstName, lastName);
	}

	public Person findPersonByAddress(String personsAddress) {
		return pdao.findPersonByAddress(personsAddress);
	}

	public boolean deletePersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.deletePersonByFirstAndLastName(firstName, lastName);

	}

	public Person updatePerson(String firstName, String lastName, String personsAddress, String city, String zip,
			String phone, String email) {
		return pdao.updatePerson(firstName, lastName, personsAddress, city, zip, phone, email);
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
				for (Person p : pdao.getPersons()) {
					if (p.getAddress().contains((CharSequence) listAddressByNumber)) {
						listPhone.add(p.getPhone());
					}
				}
			}
		}
		return listPhone;

	}

}
