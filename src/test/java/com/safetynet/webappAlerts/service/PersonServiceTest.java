package com.safetynet.webappAlerts.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webappAlerts.config.AlertsReaderTest;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.Person;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private static PersonDAO pdao;

	@Mock
	private static PersonService ps;

	@Mock
	private static Data d;

	@Mock
	private static AlertsReaderTest ar;

	@BeforeEach
	private void setUpTest() throws FileNotFoundException, IOException {

		d = new Data();
		pdao = new PersonDAO();
		ps = new PersonService();

	}

	@Test
	public void listEmailTest() {

		List<Person> persons = new ArrayList<Person>();

		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "1500 St", "Culver", "33500", "855-305-1212", "ggjs@gmail.com");

		persons.add(p);
		persons.add(pr);

		Data.arrayPerson.add(p);
		Data.arrayPerson.add(pr);

		when(pdao.getPersons()).thenReturn(persons);

		assertNotNull(ps.listOfEmail("Culver"));

	}

	@Test
	public void listOfPhone() {

	}

	@Test
	public void ChildAlert() {

	}

	@Test
	public void FireList() {

	}

	@Test
	public void PersonInfo() {

	}

}
