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
public class PersonControllerTest {

	@Autowired
	public MockMvc mockMvc;

	@Autowired
	PersonController pc;

	@Test
	public void testGetPerson() throws Exception {
		mockMvc.perform(get("/persons")).andExpect(status().isOk());
	}

	@Test
	public void testGetPersonByName() throws Exception {
		mockMvc.perform(get("/person/John/Boyd")).andExpect(status().isOk());
	}

	@Test
	public void testPutPerson() throws Exception {
		mockMvc.perform(put("/person/John/Boyd/1509 Culver St/Culver/97451/841-874-6512/jaboyd@email.com"))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeletePersonByName() throws Exception {
		mockMvc.perform(delete("/person/John/Boyd")).andExpect(status().isOk());
	}

	
}
