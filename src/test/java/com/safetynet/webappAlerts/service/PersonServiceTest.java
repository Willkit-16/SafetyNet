package com.safetynet.webappAlerts.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webappAlerts.config.AlertsReaderTest;
import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.dto.ChildAlertDTO;
import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.dto.FireDTO;
import com.safetynet.webappAlerts.dto.FireListDTO;
import com.safetynet.webappAlerts.dto.PersonInfoDTO;
import com.safetynet.webappAlerts.dto.PersonInfoListDTO;
import com.safetynet.webappAlerts.model.Data;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.MedicalRecords;
import com.safetynet.webappAlerts.model.Person;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	private static PersonService ps;

	private Person p;
	private FireStation f;
	private MedicalRecords m;

	private static Data d;

	@Mock
	private static AlertsReaderTest ar;
	@Mock
	private static FireStationDAO fsdao;
	@Mock
	private static MedicalRecordsDAO mdao;
	@Mock
	private static PersonDAO pdao;
	@Mock
	private static ChildAlertDTO cdto;
	@Mock
	private static ChildAlertListDTO cldto;
	@Mock
	private static FireDTO fdto;
	@Mock
	private static FireListDTO fldto;
	@Mock
	private static PersonInfoDTO pidto;
	@Mock
	private static PersonInfoListDTO pildto;

	@BeforeAll
	private static void setUp() {

		ps = new PersonService();
		d = new Data();

	}

	@BeforeEach
	private void setUpTest() throws FileNotFoundException, IOException {
		ar = new AlertsReaderTest();
		ar.readDataFromJson();
		pdao = new PersonDAO();
		pdao.getPersons();
	}

	@Test
	public void ListEmailTest() {
		assertNotNull(ps.listOfEmail("Culver"));
	}

}
