package com.safetynet.webappAlerts.dao;

import org.springframework.stereotype.Repository;

import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.Person;

@Repository
public class PersonDAO {

	public void updatePerson(Person pr) {

	}

	public Person addPerson(Person pr) {
		Data.arrayPerson.add(pr);
		return pr;
	}

	public void deletePerson() {

	}
}
