package com.safetynet.webappAlerts.service;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
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

	private static PersonDAO pdao;
	private static PersonService ps;

	@Mock
	private static Data d;

	@Mock
	private static AlertsReaderTest ar;

	@BeforeAll
	private static void setUp() {
		ps = new PersonService();
		pdao = new PersonDAO();
	}

	@BeforeEach
	private void setUpTest() throws FileNotFoundException, IOException {
		d = new Data();

		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "1500 St", "Culver", "33500", "855-305-1212", "ggjs@gmail.com");
		Data.arrayPerson.add(p);
		Data.arrayPerson.add(pr);
		pdao.getPersons();
		// créer données ici
		// remplir les datas
	}

	@Test
	public void ListEmailTest() throws FileNotFoundException, IOException {
		assertEquals(2, ps.listOfEmail("Culver"));
		// vérification email
	}

}
