package com.safetynet.webappAlerts.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.webappAlerts.config.AlertsReaderTest;
import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.MedicalRecords;

@SpringBootTest
public class MedicalRecordsDAOTest {

	@SuppressWarnings("unused")
	private static MedicalRecordsDAO mdao;

	@Mock
	AlertsReaderTest ar;
	@Mock
	Data data;

	@BeforeAll
	private static void setUp() {
		mdao = new MedicalRecordsDAO();
	}

	@BeforeEach
	public void setMedicalRecords() {
		ar = new AlertsReaderTest();
		data = new Data();
		MedicalRecords mr = new MedicalRecords("Jack", "Smith",
				LocalDate.parse("05-06-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy")), "Aznol:350g", "peanuts");
		Data.getArrayMR().add(mr);
	}

	@Test
	public void getMRTest() {
		assertNotNull(mdao.getMedicalRecords());
	}

	@Test
	public void findMRTest() {
		assertNotNull(mdao.findMRByFirstNameAndLastName("Jack", "Smith"));
	}

	@Test
	public void deleteMRTest() {
		assertTrue(mdao.deleteMRByFirstAndLastName("Jack", "Smith"));
	}

	@Test
	public void updateErrorTest() {
		assertNull(mdao.updateMR("Johnny", "Smoth", null, null, null));
	}

	@Test
	public void updateMRTest() {
		assertNotNull(mdao.updateMR("Jack", "Smith",
				LocalDate.parse("05-06-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy")), "Prozol:750gr", ""));
	}

}
