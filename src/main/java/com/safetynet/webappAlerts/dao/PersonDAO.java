package com.safetynet.webappAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.Person;

@Repository
public class PersonDAO {

	public Person addPerson(Person pr) {
		Data.getArrayPerson().add(pr);
		return pr;
	}

	public List<Person> getPersons() {
		return Data.getArrayPerson();
	}

	public Person findPersonByFirstNameAndLastName(String firstName, String lastName) {
		for (Person p : Data.getArrayPerson()) {
			if (p.firstName.equals(firstName) && p.lastName.equals(lastName)) {
				return p;
			}
		}
		return null;
	}

	public boolean deletePersonByFirstAndLastName(String firstName, String lastName) {
		for (Person p : Data.getArrayPerson()) {
			if (p.firstName.equals(firstName) && p.lastName.equals(lastName)) {
				return Data.getArrayPerson().remove(p);
			}
		}
		return false;

	}

	public Person updatePerson(String firstName, String lastName, String personsAddress, String city, String zip,
			String phone, String email) {
		for (Person p : Data.getArrayPerson()) {
			if (p.firstName.equals(firstName) && p.lastName.equals(lastName)) {
				p.setAddress(personsAddress);
				p.setCity(city);
				p.setEmail(email);
				p.setPhone(phone);
				p.setZip(zip);

				return p;
			}
		}
		return null;
	}
}
