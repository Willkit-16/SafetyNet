package com.safetynet.webappAlerts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FireStationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetFireStations() throws Exception {
		mockMvc.perform(get("/firestations")).andExpect(status().isOk());
	}

	@Test
	public void testGetFireStationByNumber() throws Exception {
		mockMvc.perform(get("/firestation/1")).andExpect(status().isOk());
	}

	@Test
	public void testGetFireStationByStationAndAddress() throws Exception {
		mockMvc.perform(get("/firestation/3/1509 Culver St")).andExpect(status().isOk());
	}

	@Test
	public void testPutFireStation() throws Exception {
		mockMvc.perform(put("/firestation/3/1700 Culver St")).andExpect(status().isOk());
	}

	@Test
	public void testDeleteFireStation() throws Exception {
		mockMvc.perform(delete("/firestation/3/1509 Culver St")).andExpect(status().isOk());
	}

	
}
