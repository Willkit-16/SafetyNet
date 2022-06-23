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
import com.safetynet.webappAlerts.dto.FloodDTO;
import com.safetynet.webappAlerts.dto.FloodListDTO;
import com.safetynet.webappAlerts.model.FireStation;
import com.safetynet.webappAlerts.model.Person;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordsServiceTest {

	@Mock
	private static AlertsReader ar;
	@Mock
	private static FireStationDAO fsdao;
	@Mock
	private static MedicalRecordsDAO mdao;
	@Mock
	private static PersonDAO pdao;
	@Mock
	private static FloodDTO fdto;
	@Mock
	private static FloodListDTO fldto;

	@BeforeEach
	private void setUpTest() {
		FireStation f = new FireStation();
		Person p = new Person();
	}

	@Test
	public void floodListTest() {

	}

}
