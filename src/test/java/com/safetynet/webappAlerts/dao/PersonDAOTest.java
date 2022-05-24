package com.safetynet.webappAlerts.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webappAlerts.config.AlertsReaderTest;
import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.Person;

@ExtendWith(MockitoExtension.class)
public class PersonDAOTest {

	private static PersonDAO pdao;

	@Mock
	AlertsReaderTest ar;
	@Mock
	Data data;

	@BeforeAll
	private static void setUp() {
		pdao = new PersonDAO();
	}

	@BeforeEach
	public void setPerson() {
		ar = new AlertsReaderTest();
		data = new Data();
		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Data.arrayPerson.add(p);
		Data.arrayPerson.add(pr);

		pdao.updatePerson("John", "Smith", "4500", "Culver", "44500", "855-305-1100", "js@gmail.com");
	}

	@Test
	public void getPersonTest() {
		assertNotNull(pdao.getPersons());
	}

	@Test
	public void findPersonTest() {
		assertNotNull(pdao.findPersonByFirstNameAndLastName("Jack", "Smith"));
	}

	@Test
	public void deletePersonTest() {
		assertTrue(pdao.deletePersonByFirstAndLastName("Jack", "Smith"));
	}

	@Test
	public void updateErrorTest() {
		assertNull(pdao.updatePerson("Sof", "Down", null, null, null, null, null));
	}

	@Test
	public void updatePersonTest() {
		assertNotNull(pdao.updatePerson("John", "Smith", "4500", "Culver", "44500", "855-305-1100", "js@gmail.com"));
	}

}
