package com.safetynet.webappAlerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonDAO pdao;

	@Autowired
	FireStationDAO fsdao;

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

	public List<String> listOfPhone(String stationNumber) {
		List <String> listPhone = new ArrayList<String>();
		List <String> listAddress = new ArrayList<String>();
		
		listAddress = fsdao.findFSByNumber(stationNumber).getAddress();
		
		for (Person p : pdao.getPersons()) {
			if (p.getAddress().) //On fait une boucle for each sur listAddress puis tester p.getAddress = élément de la boucle for each listAddress, si oui add phone à la listePhone.Puis retourne listPhone après les deux boucles.
		}
	}

}
