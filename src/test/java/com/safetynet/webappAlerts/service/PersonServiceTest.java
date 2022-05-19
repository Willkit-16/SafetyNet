package com.safetynet.webappAlerts.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webappAlerts.controller.AlertsReader;
import com.safetynet.webappAlerts.dao.FireStationDAO;
import com.safetynet.webappAlerts.dao.MedicalRecordsDAO;
import com.safetynet.webappAlerts.dao.PersonDAO;
import com.safetynet.webappAlerts.dto.ChildAlertDTO;
import com.safetynet.webappAlerts.dto.ChildAlertListDTO;
import com.safetynet.webappAlerts.dto.FireDTO;
import com.safetynet.webappAlerts.dto.FireListDTO;
import com.safetynet.webappAlerts.dto.PersonInfoDTO;
import com.safetynet.webappAlerts.dto.PersonInfoListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.Person;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@Mock
	private static AlertsReader ar;
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

	@BeforeEach
	private void setUpTest() {
		FireStation f = new FireStation();
		Person p = new Person();
	}

	@Test
	private void ListFSTest() {

	}

}
