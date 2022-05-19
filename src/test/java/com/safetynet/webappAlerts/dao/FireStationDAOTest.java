package com.safetynet.webappAlerts.dao;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
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

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void addFSTest() {
		FireStation fs = new FireStation("4500 Culver", "4");
		equals(fdao.addFireStation(fs));
	}

	@Test
	public void updateFSError() {
		assertNull(fdao.updateFireStation("2", null));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void updateFS() {
		equals(fdao.updateFireStation("1509 Culver St", "5"));
	}

	@Test
	public void deleteFS() {
		assertTrue(fdao.deleteFSByStationAndAddress("3", "1509 Culver St"));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void FindFS() {
		FireStation fs = new FireStation();
		equals(fs);
	}
}
