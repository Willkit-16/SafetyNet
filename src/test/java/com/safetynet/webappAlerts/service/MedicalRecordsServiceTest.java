package com.safetynet.webappAlerts.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

@SpringBootTest
public class MedicalRecordsServiceTest {

	@MockBean
	PersonDAO pdao;

	@MockBean
	FireStationDAO fdao;

	@MockBean
	MedicalRecordsDAO mdao;

	@Autowired
	MedicalRecordsService mrs;

	@Test
	public void floodListTest() {

		LocalDate localDate = LocalDate.parse("2020-05-15");

		LocalDate localDate2 = LocalDate.parse("1995-05-15");

		List<Person> persons = new ArrayList<Person>();

		List<MedicalRecords> medics = new ArrayList<MedicalRecords>();

		List<FireStation> fireStations = new ArrayList<FireStation>();

		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "1500 St", "Culver", "33500", "855-305-1212", "ggjs@gmail.com");

		MedicalRecords m = new MedicalRecords("Jack", "Smith", localDate, "", "Peanut");
		MedicalRecords mr = new MedicalRecords("John", "Smith", localDate2, "", "");

		FireStation f = new FireStation("4300 St", "1");

		persons.add(p);
		persons.add(pr);

		medics.add(m);
		medics.add(mr);

		fireStations.add(f);

		Mockito.when(pdao.getPersons()).thenReturn(persons);
		Mockito.when(mdao.getMedicalRecords()).thenReturn(medics);
		Mockito.when(fdao.getFireStations()).thenReturn(fireStations);

		assertNotNull(mrs.familyByStation("1"));
	}

}
