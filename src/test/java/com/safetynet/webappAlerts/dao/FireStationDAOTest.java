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
import com.safetynet.webappAlerts.model.FireStation;

@ExtendWith(MockitoExtension.class)
public class FireStationDAOTest {

	private static FireStationDAO fdao;

	@Mock
	AlertsReaderTest ar;
	@Mock
	Data data;

	@BeforeAll
	private static void setUp() {
		fdao = new FireStationDAO();

	}

	@BeforeEach
	public void setFireStation() {
		ar = new AlertsReaderTest();
		data = new Data();
		FireStation fs = new FireStation("4500 Culver", "4");
		FireStation fsB = new FireStation("1509 Culver St", "3");

		Data.arrayFS.add(fs);
		Data.arrayFS.add(fsB);

		fdao.updateFireStation("3", "1509 Culver St");
	}

	@Test
	public void addFSTest() {
		FireStation fs = new FireStation("7000 Culver", "4");
		assertNotNull(fdao.addFireStation(fs));
	}

	@Test
	public void updateFSError() {
		assertNull(fdao.updateFireStation("2", null));
	}

	@Test
	public void updateFS() {
		assertNotNull(fdao.updateFireStation("3", "1509 Culver St"));
	}

	@Test
	public void deleteFS() {
		assertTrue(fdao.deleteFSByStationAndAddress("4", "4500 Culver"));
	}

	@Test
	public void FindFS() {
		assertNotNull(fdao.findFSByStationAndAddress("3", "1509 Culver St"));
	}
}
