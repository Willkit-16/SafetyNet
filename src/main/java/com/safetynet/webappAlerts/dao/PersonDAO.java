package com.safetynet.webappAlerts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.Person;

@Repository
public class PersonDAO {

	public void addPerson(Person pr) {
		Data.arrayPerson.add(pr);
	}

	public List<Person> getPersons() {
		return Data.arrayPerson;
	}

	public Person findPersonByFirstNameAndLastName(String firstName, String lastName) {
		for (Person p : Data.arrayPerson) {
			if (p.firstName.equals(firstName) && p.lastName.equals(lastName)) {
				return p;
			}
		}
		return null;
	}

	public boolean deletePersonByFirstAndLastName(String firstName, String lastName) {
		for (Person p : Data.arrayPerson) {
			if (p.firstName.equals(firstName) && p.lastName.equals(lastName)) {
				return Data.arrayPerson.remove(p);
			}
		}
		return false;

	}

}
