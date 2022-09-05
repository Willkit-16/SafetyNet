package com.safetynet.webappAlerts.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.safetynet.webappAlerts.config.AlertsReaderTest;
import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.dto.FireListDTO;
import com.safetynet.webappAlerts.dto.PersonInfoDTO;
import com.safetynet.webappAlerts.dto.PersonInfoListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

@SpringBootTest
public class PersonServiceTest {

	@MockBean
	PersonDAO pdao;

	@MockBean
	FireStationDAO fdao;

	@MockBean
	MedicalRecordsDAO mdao;

	@MockBean
	PersonInfoDTO pdto;

	@Autowired
	private PersonService ps;

	@Mock
	private static AlertsReaderTest ar;

	@Test
	public void listEmailTest() {

		List<Person> persons = new ArrayList<Person>();

		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "1500 St", "Culver", "33500", "855-305-1212", "ggjs@gmail.com");

		persons.add(p);
		persons.add(pr);

		Mockito.when(pdao.getPersons()).thenReturn(persons);

		assertThat(ps.listOfEmail("Culver").size()).isEqualTo(2);
	}

	@Test
	public void listOfPhone() {

		List<Person> persons = new ArrayList<Person>();
		List<FireStation> fireStations = new ArrayList<FireStation>();

		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "1500 St", "Culver", "33500", "855-305-1212", "ggjs@gmail.com");

		FireStation f = new FireStation("4300 St", "1");

		persons.add(p);
		persons.add(pr);

		fireStations.add(f);

		Mockito.when(pdao.getPersons()).thenReturn(persons);
		Mockito.when(fdao.getFireStations()).thenReturn(fireStations);

		assertThat(ps.listOfPhone("1").size()).isEqualTo(1);

	}

	@Test
	public void childAlertTest() {
		LocalDate localDate = LocalDate.parse("2020-05-15");

		LocalDate localDate2 = LocalDate.parse("1995-05-15");

		List<Person> persons = new ArrayList<Person>();

		List<MedicalRecords> medics = new ArrayList<MedicalRecords>();

		ChildAlertListDTO cal = new ChildAlertListDTO();

		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "1500 St", "Culver", "33500", "855-305-1212", "ggjs@gmail.com");

		MedicalRecords m = new MedicalRecords("Jack", "Smith", localDate, "", "Peanut");
		MedicalRecords mr = new MedicalRecords("John", "Smith", localDate2, "", "");

		persons.add(p);
		persons.add(pr);

		medics.add(m);
		medics.add(mr);

		Mockito.when(pdao.getPersons()).thenReturn(persons);
		Mockito.when(mdao.getMedicalRecords()).thenReturn(medics);

		cal = ps.listOfChildren("4300 St");

		assertNotNull(ps.listOfChildren("4300 St"));

		assertThat(cal.getListOfChildren().size()).isEqualTo(1);

	}

	@Test
	public void fireListTest() {

		LocalDate localDate = LocalDate.parse("2020-05-15");

		LocalDate localDate2 = LocalDate.parse("1995-05-15");

		List<Person> persons = new ArrayList<Person>();

		List<MedicalRecords> medics = new ArrayList<MedicalRecords>();

		List<FireStation> fireStations = new ArrayList<FireStation>();

		FireListDTO fld = new FireListDTO();

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

		fld = ps.listByAddress("1500 St");

		assertNotNull(ps.listByAddress("1500 St"));

		assertThat(fld.getListOfPersonByAddress().size()).isEqualTo(1);

	}

	@Test
	public void personInfoTest() {

		LocalDate localDate = LocalDate.parse("2020-05-15");

		LocalDate localDate2 = LocalDate.parse("1995-05-15");

		List<Person> persons = new ArrayList<Person>();

		List<MedicalRecords> medics = new ArrayList<MedicalRecords>();

		PersonInfoListDTO pio = new PersonInfoListDTO();

		Person p = new Person("Jack", "Smith", "4300 St", "Culver", "33500", "855-305-1100", "js@gmail.com");
		Person pr = new Person("John", "Smith", "1500 St", "Culver", "33500", "855-305-1212", "ggjs@gmail.com");

		MedicalRecords m = new MedicalRecords("Jack", "Smith", localDate, "", "Peanut");
		MedicalRecords mr = new MedicalRecords("John", "Smith", localDate2, "", "");

		persons.add(p);
		persons.add(pr);

		medics.add(m);
		medics.add(mr);

		Mockito.when(pdao.getPersons()).thenReturn(persons);
		Mockito.when(mdao.getMedicalRecords()).thenReturn(medics);
		Mockito.when(pdto.getFirstName()).thenReturn("Jack");

		pio = ps.personInfo("Jack", "Smith");

		assertNotNull(ps.personInfo("Jack", "Smith"));

		assertThat(pio.getPersonInfoList().size()).isEqualTo(1);

	}

}
