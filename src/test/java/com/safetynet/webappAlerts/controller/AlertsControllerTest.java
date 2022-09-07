package com.safetynet.webappAlerts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AlertsControllerTest {

	@Autowired
	public MockMvc mockMvc;

	@Autowired
	AlertsController ar;

	@Test
	public void testGetEmail() throws Exception {
		mockMvc.perform(get("/communityEmail/?city=Culver")).andExpect(status().isOk());
	}

	@Test
	public void testGetPhoneAlerts() throws Exception {
		mockMvc.perform(get("/phoneAlert/?firestation=3")).andExpect(status().isOk());
	}

	@Test
	public void testPeopleByNumberList() throws Exception {
		mockMvc.perform(get("/firestation/?stationNumber=1")).andExpect(status().isOk());
	}

	@Test
	public void testChildAlert() throws Exception {
		mockMvc.perform(get("/childAlert/?address=1509 Culver St")).andExpect(status().isOk());
	}

	@Test
	public void testFire() throws Exception {
		mockMvc.perform(get("/fire/?address=947 E. Rose Dr")).andExpect(status().isOk());
	}

	@Test
	public void testFloodStation() throws Exception {
		mockMvc.perform(get("/flood/stations/?stations=2")).andExpect(status().isOk());
	}

	@Test
	public void testPersonInfo() throws Exception {
		mockMvc.perform(get("/personInfo?firstName=John&lastName=Boyd")).andExpect(status().isOk());
	}

}