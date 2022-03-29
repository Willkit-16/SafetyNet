package com.safetynet.webappAlerts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.model.Person;

@Service
public class PersonService {

	@Autowired
	PersonDAO pdao;

	public List<Person> getPersons() {
		return pdao.getPersons();
	}

	public boolean createAndAddPerson(String firstName, String lastName, String personAddress, String city, String zip,
			String phone, String email) {
		Person pr = new Person(firstName, lastName, personAddress, city, zip, phone, email);
		return pdao.addPerson(pr);
	}

	public Person findPersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.findPersonByFirstNameAndLastName(firstName, lastName);
	}

	public boolean deletePersonByFirstAndLastName(String firstName, String lastName) {
		return pdao.deletePersonByFirstAndLastName(firstName, lastName);

	}

}
