package com.safetynet.webappAlerts.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(controllers = FireStationController.class)
public class FireStationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetFireStations() throws Exception {
		mockMvc.perform(get("/firestations")).andExpect(status().isOk()).andExpect(jsonPath("$[0].station", is("3")));
	}
}
